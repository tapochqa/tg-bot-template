all: render test


render:
	rm -rf target
	lein new tg-bot tb --to-dir target/tb

test:
	cd target/tb && lein run 

lint:
	cd target/tb && clj-kondo --lint src