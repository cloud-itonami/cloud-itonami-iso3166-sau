(ns marketentry.facts "Saudi Arabia market-entry catalog.")
(def catalog
  {"SAU" {:name "Kingdom of Saudi Arabia"
          :owner-authority "LTP / Etimad"
          :legal-basis "Government Tenders and Procurement Law"
          :national-spec "Etimad supplier registration + CR number"
          :provenance "https://tenders.etimad.sa/"
          :required-evidence ["CR number record" "Etimad registration record" "CR extract" "Authorized-representative record"]
          :rep-owner-authority "contracting authorities / LTP"
          :rep-legal-basis "Saudi commercial registration typically required for Etimad participation"
          :rep-provenance "https://tenders.etimad.sa/"
          :corporate-number-owner-authority "Ministry of Commerce / ZATCA"
          :corporate-number-legal-basis "Commercial Registration (CR) number"
          :corporate-number-provenance "https://mc.gov.sa/"}
   "USA" {:name "United States" :owner-authority "GSA/SAM.gov" :legal-basis "FAR" :national-spec "SAM.gov" :provenance "https://sam.gov/"
          :required-evidence ["EIN record" "SAM.gov registration record" "State business registration record" "SAM UEI verification record"]}
   "ARE" {:name "UAE" :owner-authority "Federal e-procurement" :legal-basis "Federal procurement" :national-spec "e-procurement" :provenance "https://www.mof.gov.ae/"
          :required-evidence ["Trade license" "e-procurement registration" "License extract" "Authorized-representative record"]}
   "EGY" {:name "Egypt" :owner-authority "e-Tenders" :legal-basis "Law 182/2018" :national-spec "e-Tenders" :provenance "https://etenders.gov.eg/"
          :required-evidence ["Commercial registry" "e-Tenders registration" "Tax card" "Authorized-representative record"]}})

(defn spec-basis [iso3] (get catalog iso3))
(defn coverage
  ([] (coverage (keys catalog)))
  ([iso3s]
   (let [have (filter catalog iso3s) missing (remove catalog iso3s)]
     {:requested (count iso3s) :covered (count have)
      :covered-jurisdictions (vec (sort have))
      :missing-jurisdictions (vec (sort missing))
      :note "R0 catalog seed"})))
(defn required-evidence-satisfied? [iso3 submitted]
  (when-let [{:keys [required-evidence]} (spec-basis iso3)]
    (= (count required-evidence) (count (filter (set submitted) required-evidence)))))
(defn evidence-checklist [iso3] (:required-evidence (spec-basis iso3) []))
(defn rep-spec-basis [iso3]
  (when-let [sb (spec-basis iso3)]
    (when (:rep-owner-authority sb)
      (select-keys sb [:rep-owner-authority :rep-legal-basis :rep-provenance]))))
(defn corporate-number-spec-basis [iso3]
  (when-let [sb (spec-basis iso3)]
    (when (:corporate-number-owner-authority sb)
      (select-keys sb [:corporate-number-owner-authority :corporate-number-legal-basis :corporate-number-provenance]))))
