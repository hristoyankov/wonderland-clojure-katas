(ns fox-goose-bag-of-corn.puzzle)

(def start-pos [[[:fox :goose :corn :you] [:boat] []]
                [[:corn :fox] [:you :goose :boat] []]
                [[:corn :fox] [:boat] [:you :goose]]
                [[:corn :fox] [:you :boat] [:goose]]
                [[:corn :fox :you] [:boat] [:goose]]
                [[:corn] [:boat :you :fox] [:goose]]
                [[:corn] [:boat] [:you :fox :goose]]
                [[:corn] [:boat :you :goose] [:fox]]
                [[:corn :you :goose] [:boat] [:fox]]
                [[:goose] [:boat :you :corn] [:fox]]
                [[:goose] [:boat] [:fox :you :corn]]
                [[:goose] [:boat :you] [:fox :corn]]
                [[:goose :you] [:boat] [:fox :corn]]
                [[] [:boat :you :goose] [:fox :corn]]
                [[] [:boat] [:fox :goose :corn :you]]])

(defn river-crossing-plan []
  start-pos)
