<!-- ABOUT THE PROJECT -->

## Android Version Catalog Migration Script

### Problem 
Migrating the build to version catalog poses a hurdle. Manually naming dependencies is messy and time-consuming, 
and adhering to naming conventions can be particularly time-consuming with larger projects that have numerous dependencies.

### Solution 
To simplify this process, I have created a script that takes old dependencies as input and generates dependencies in the `libs.versions.toml` format.

### Current Implementation 
eg. it takes this as input

```implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.3.1")```


and returns


```
[versions]
kotlin-bom = "1.8.0"

[libraries]
kotlin-bom = { group = "org.jetbrains.kotlin", name = "kotlin-bom", version.ref = "kotlin-bom"}
```


### What's next
<strike>Generate complete `libs.versions.toml` file</strike>
<strike>Generate updated dependencies which will be added in `build.gradle` which will reference dependencies of `toml`</strike>

