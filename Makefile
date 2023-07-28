all: render test


render:
	rm -rf target
	lein new tg-bot tb --to-dir target/tb

test:
	cd target/tb && lein run 0

lint:
	cd target/tb && clj-kondo --lint src

deploy:
	lein deploy clojars