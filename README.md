FluentLenium-BrowserStack
=========

Sample for using [FluentLenium] with BrowserStack Automate.

### Setup
*Starting and prerequisite: [FluentLenium] and maven*
  - `maven complie`

### Configuring Tests
- Open `src/main/java/com/browserstack/App.java`
- Add `USERNAME` and `ACCESS_KEY` with your BrowserStack credentials. Don't have one? Get one on BrowserStack [dashboard]
- Optionally, add your credentials to the environment variables `BROWSERSTACK_USERNAME` and `BROWSERSTACK_ACCESS_KEY`
- Add / customise more [capabilities] to `desiredCapabilities` in `App.java`

### Run the tests
- To start the sample test simply run `mvn exec:java -Dexec.mainClass="com.browserstack.App"`

[FluentLenium]:https://github.com/FluentLenium/FluentLenium
[capabilities]:http://www.browserstack.com/automate/capabilities
[dashboard]:https://www.browserstack.com/automate
