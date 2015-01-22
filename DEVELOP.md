Some information for developers.

# Release

## Configure [GitHub release plugin](https://github.com/jutzig/github-release-plugin)

1. Go to [GitHub Applications](https://github.com/settings/applications) and create new personal access tokens with atleast this rights:
  * public_repo
2. Open Maven `settings.xml` and create new section:
```xml
	<server>
		<id>github-locale-kazakh</id>
		<privateKey>0000000000000000000000000000000000000000</privateKey>
	</server>
```

## Create release

Run command `mvn release:prepare release:perform` and maven make this actions:
1. Update project version from snapshot to release
1. Build project with goals 'clean verify'
1. Commit and push migration to release version
1. Create tag
1. Update project version to new snapshot version
1. Commit and push migration to snapshot version
1. Perform local checkout project sources
1. Build project with goal 'install' and enabled profile 'release'
1. After phase 'install' will be triggered execution 'github-upload', which create release on GitHub and upload to this release project artifact
