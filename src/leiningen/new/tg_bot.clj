(ns leiningen.new.tg-bot
  (:require [leiningen.new.templates :as tmpl]
            [leiningen.core.main :as main]))

(def render (tmpl/renderer "tg_bot"))

(defn tg-bot
  "FIXME: write documentation"
  [name]
  (let [data {:name name
              :sanitized (tmpl/name-to-path name)}]
    (main/info "Generating fresh 'lein new' tg-bot project.")
    (tmpl/->files data
                  ["README.md"                      (render "README.md" data)]
                  [".gitignore"                     (render "gitignore" data)]
                  ["project.clj"                    (render "project.clj" data)]
                  ["Makefile"                       (render "Makefile" data)]
                  ["builds/.keep"                   (render "keep" data)]
                  ["reflection-config.json"         (render "reflection-config.json")]
                  ["src/{{sanitized}}/core.clj"     (render "src/core.clj" data)]
                  ["src/{{sanitized}}/telegram.clj" (render "src/telegram.clj" data)]
                  ["src/{{sanitized}}/polling.clj"  (render "src/polling.clj" data)]
                  ["src/{{sanitized}}/handling.clj" (render "src/handling.clj" data)])))
