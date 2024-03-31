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


```lifecycle-runtime-ktx = { group = "androidx.lifecycle", name = "lifecycle-runtime-ktx", version.ref = "2.3.1"}```


### What's next
Goal is to generate complete `libs.versions.toml` file & also generate updated dependencies which will be added in `build.gradle` which will reference dependencies of `toml`

