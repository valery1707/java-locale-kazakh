# INSTALLATION

REQUIREMENTS: Java SE 8 or higher.

## 1. Installing

### 1.1. Installing permanently into your JVM

For installing Kazakh locale, just copy the `locale-kazakh-java8-{version}.jar` file into your Java virtual machine's extension folder:

* For a Java JDK: $JAVA_HOME/jre/lib/ext
* For a Java JRE: $JAVA_HOME/lib/ext
* For an Apple Java JDK/JRE in Mac OS X: /Library/Java/Extensions

### 1.2. Specifying as parameter on VM start

If you prefer not to install the Kazakh locale file into your VM's folder, you can copy it into any other folder and specify it as a VM parameter:

```bash
$ java -Djava.ext.dirs=$MY_EXTENSIONS_DIR ...
```
