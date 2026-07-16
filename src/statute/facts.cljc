(ns statute.facts
  "General-law compliance catalog for Saudi Arabia (SAU) -- a 41st
  country-level entry (see cloud-itonami-iso3166-jpn/-usa/-gbr/-deu/-fra/
  -can/-aus/-kor/-nld/-ita/-esp/-swe/-nor/-dnk/-fin/-prt/-bel/-bra/-mex/
  -chl/-arg/-zaf/-col/-ury/-cri/-pan/-ecu/-pry/-gtm/-hnd/-ind/-ken/-tha/
  -are/-vnm/-idn/-phl/-egy/-tur/-nga for the first forty) per
  ADR-2607141700 (cloud-itonami-compliance-fact-federation).

  Reuses this tick-window's already-verified capital-status finding
  from cloud-itonami-municipality-sau-riyadh (tick 119): Riyadh is
  Saudi Arabia's stable capital, with no ongoing ambiguity.

  Companies Law (Royal Decree No. M/132, dated 01/12/1443 AH / 30 June
  2022) -- title, decree number, and date directly confirmed by
  reading the English-language mirror hosted at gccbdi.org (the Gulf
  Cooperation Council Board Directors Institute) via the Read-tool
  saved-path fallback (its first page reads verbatim: 'Royal Decree
  No. [M/132] Dated 01/12/1443 AH... We, Salman bin Abdulaziz Al Saud,
  King of Saudi Arabia...' -- the King's name appearing only in the
  decree's own standard promulgation clause, never persisted to this
  catalog). Two other primary-source attempts failed first: the
  Ministry of Investment's (misa.gov.sa) own PDF rendered entirely
  illegible via Arabic-script font-subsetting (the same issue seen at
  tick 119 for Riyadh's municipal law), and the Lexis Middle East
  legal database's page conflated the law's entry-into-force date (19
  January 2023) with its actual Royal Decree issuance date -- caught
  by cross-checking against the GCCBDI primary source rather than
  trusting the secondary synthesis.

  Personal Data Protection Law (Royal Decree No. M/19, dated 9/2/1443
  H / 16 September 2021) -- directly confirmed via DLA Piper's 'Data
  Protection Laws of the World' resource (a professional
  legal-research publication, the same category of source as WIPO Lex
  / ECOLEX / Lexis Middle East used elsewhere this session), which
  states verbatim: 'Personal Data Protection Law (issued pursuant to
  Royal Decree No. M/19 of 9/2/1443 H (corresponding to 16 September
  2021)'. SDAIA's (Saudi Data & AI Authority) own official domain
  rejected every WebFetch attempt (bot-detection 'Request Rejected'
  responses on both its PDF and HTML pages), and WebSearch synthesis
  alone had shown a 1-day discrepancy (16 vs 17 September) that this
  directly-read primary source resolved.

  An entry not in this table has NO spec-basis, full stop; extend
  `catalog`, do not invent an id/url/date.")

(def catalog
  "ISO3166 alpha-3 -> vector of statute entries."
  {"SAU"
   [{:statute/id "sau.royal-decree-m132-1443-companies-law"
     :statute/title "Companies Law"
     :statute/jurisdiction "SAU"
     :statute/kind :law
     :statute/law-number "Royal Decree No. M/132"
     :statute/url "https://gccbdi.org/sites/default/files/content-files/Resources/Governance%20&%20Director%20Information/KSA/Company%20Law%202022%20-%20(English).pdf"
     :statute/url-provenance :gccbdi-org-mirror
     :statute/enacted-date "2022-06-30"
     :statute/retrieved-at "2026-07-17"
     :statute/topic #{:corporate-governance :incorporation}}
    {:statute/id "sau.royal-decree-m19-1443-personal-data-protection-law"
     :statute/title "Personal Data Protection Law"
     :statute/jurisdiction "SAU"
     :statute/kind :law
     :statute/law-number "Royal Decree No. M/19"
     :statute/url "https://www.dlapiperdataprotection.com/?c=SA"
     :statute/url-provenance :dlapiper-data-protection-laws-of-the-world
     :statute/enacted-date "2021-09-16"
     :statute/retrieved-at "2026-07-17"
     :statute/topic #{:data-protection :privacy}}]})

(defn spec-basis [jurisdiction] (get catalog jurisdiction))

(defn coverage
  ([] (coverage (keys catalog)))
  ([jurisdictions]
   (let [have (filter catalog jurisdictions)
         missing (remove catalog jurisdictions)]
     {:requested (count jurisdictions)
      :covered (count have)
      :covered-jurisdictions (vec (sort have))
      :missing-jurisdictions (vec (sort missing))
      :note (str "cloud-itonami-iso3166-sau statute.facts Wave 0 (ADR-2607141700): "
                 (count (get catalog "SAU")) " Saudi Arabia entries seeded "
                 "with gccbdi.org/dlapiperdataprotection.com citations. "
                 "Extend `statute.facts/catalog`, never fabricate an id/url.")})))

(defn by-topic [jurisdiction topic]
  (filterv #(contains? (:statute/topic %) topic) (spec-basis jurisdiction)))
