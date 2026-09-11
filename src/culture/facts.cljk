(ns culture.facts
  "Country-level regional-culture catalog for Saudi Arabia (SAU) -- national
  dishes, protected products, beverages, crafts, festivals and heritage
  sites, per ADR-2607171400 addendum 2 (cloud-itonami-municipality-
  culture-catalog Wave 1, in com-junkawasaki/root). Sibling namespace to
  `marketentry.facts` / `statute.facts` (ADR-2607141700); city-level
  counterparts live in the cloud-itonami-municipality-* repos.

  Catalog is keyed by UPPERCASE ISO3 (mirrors `statute.facts`); entries
  carry no :culture/municipality (that attribute is city-level only).

  whc.unesco.org blocks fetches (403); heritage entries cite Wikipedia
  instead, never whc.unesco.org and never bypassing bot protection.

  Every entry cites a source URL that was actually fetched and read on
  :culture/retrieved-at -- never fabricated. Summaries state only what the
  cited source confirms. An item not in this table has NO spec-basis, full
  stop; extend `catalog`, do not invent an id/url.")

(def catalog
  "iso3 -> vector of culture entries."
  {"SAU"
   [{:culture/id "sau.dish.kabsa"
     :culture/name "Kabsa"
     :culture/country "SAU"
     :culture/kind :dish
     :culture/summary "Arab mixed rice dish, typically made with rice, vegetables, spices, herbs and either chicken, lamb, camel or beef, that originates from Saudi Arabia or Yemen and is regarded as a national dish across the Gulf Cooperation Council."
     :culture/url "https://en.wikipedia.org/wiki/Kabsa"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "sau.dish.jareesh"
     :culture/name "Jareesh"
     :culture/country "SAU"
     :culture/kind :dish
     :culture/summary "Dish of crushed wheat cooked with yogurt and chicken or other meat, part of Saudi Arabian cuisine."
     :culture/url "https://en.wikipedia.org/wiki/Saudi_Arabian_cuisine"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "sau.dish.mandi"
     :culture/name "Mandi"
     :culture/country "SAU"
     :culture/kind :dish
     :culture/summary "Meat-and-rice dish with Yemeni roots that has transcended its origin and is now popular in many parts of the Arabian Peninsula, including Saudi Arabia."
     :culture/url "https://en.wikipedia.org/wiki/Mandi_(food)"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "sau.product.ajwa-date"
     :culture/name "Ajwa"
     :culture/country "SAU"
     :culture/kind :product
     :culture/summary "Cultivar of the palm date widely grown in Medina, Saudi Arabia; oval-shaped and medium-sized with black skin."
     :culture/url "https://en.wikipedia.org/wiki/Ajwa_(date)"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "sau.beverage.gahwah"
     :culture/name "Gahwah"
     :culture/name-local "قهوة"
     :culture/country "SAU"
     :culture/kind :beverage
     :culture/summary "Arabic coffee; serving gahwah in Saudi Arabia is a sign of hospitality and generosity, with light roasting common in the Najd and Hejaz regions."
     :culture/url "https://en.wikipedia.org/wiki/Saudi_Arabian_cuisine"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "sau.craft.al-sadu"
     :culture/name "Al Sadu"
     :culture/country "SAU"
     :culture/kind :craft
     :culture/summary "Traditional weaving craft; in 2020 Al Sadu weaving in Saudi Arabia and Kuwait was inscribed on UNESCO's Representative List of the Intangible Cultural Heritage of Humanity."
     :culture/url "https://en.wikipedia.org/wiki/Al_Sadu"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "sau.festival.al-jenadriyah"
     :culture/name "Al-Jenadriyah"
     :culture/country "SAU"
     :culture/kind :festival
     :culture/summary "Cultural and heritage festival held in Jenadriyah near Riyadh, Saudi Arabia, each year, lasting for two weeks."
     :culture/url "https://en.wikipedia.org/wiki/Jenadriyah"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "sau.heritage.hegra"
     :culture/name "Hegra"
     :culture/name-local "Mada'in Salih"
     :culture/country "SAU"
     :culture/kind :heritage
     :culture/summary "Archaeological site in Saudi Arabia; in 2008 UNESCO proclaimed it a site of patrimony, becoming Saudi Arabia's first World Heritage Site."
     :culture/url "https://en.wikipedia.org/wiki/Hegra"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}]})

(defn spec-basis [iso3] (get catalog iso3))

(defn coverage
  ([] (coverage (keys catalog)))
  ([iso3s]
   (let [have (filter catalog iso3s)
         missing (remove catalog iso3s)]
     {:requested (count iso3s)
      :covered (count have)
      :covered-jurisdictions (vec (sort have))
      :missing-jurisdictions (vec (sort missing))
      :note (str "cloud-itonami-iso3166-sau culture catalog "
                 "(ADR-2607171400 addendum 2, Wave 1): " (count (get catalog "SAU"))
                 " SAU entries, each with a fetched-and-read citation. "
                 "Extend `culture.facts/catalog`, never fabricate an id/url.")})))

(defn by-kind [iso3 kind]
  (filterv #(= (:culture/kind %) kind) (spec-basis iso3)))
