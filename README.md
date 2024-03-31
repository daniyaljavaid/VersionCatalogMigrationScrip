<!-- ABOUT THE PROJECT -->

## Android Version Catalog Migration Script

### Problem 
Migrating the build to version catalog poses a hurdle. Manually naming dependencies is messy and time-consuming, 
and adhering to naming conventions can be particularly time-consuming with larger projects that have numerous dependencies.

### Solution 
To simplify this process, I have created a script that takes old dependencies as input and generates dependencies in the `libs.versions.toml` format.

### Current Implementation 
eg. it takes this as input

```
implementation(platform("org.jetbrains.kotlin:kotlin-bom:1.8.0"))
implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.3.1")
```


and generates


```
file -> libs.versions.toml

[versions]
kotlin-bom = "1.8.0"
lifecycle-runtime-ktx = "2.3.1"

[libraries]
kotlin-bom = { group = "org.jetbrains.kotlin", name = "kotlin-bom", version.ref = "kotlin-bom"}
lifecycle-runtime-ktx = { group = "androidx.lifecycle", name = "lifecycle-runtime-ktx", version.ref = "lifecycle-runtime-ktx"}


file -> build.gradle
dependencies {
	implementation(platform(libs.kotlin.bom))
  implementation(libs.lifecycle.runtime.ktx)
}

```


### What's next
- [x] Generate complete `libs.versions.toml` file

- [x] Generate updated dependencies which will be added in `build.gradle` which will reference dependencies of `toml`

- [ ] Generate toml for plugins
