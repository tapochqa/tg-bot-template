all: render test


render:
	rm -rf target
	lein new tg-bot tb --to-dir target/tb

test:
	@read -p "Token: " m; \
	cd target/tb && lein run $$m

lint:
	cd target/tb && clj-kondo --lint src