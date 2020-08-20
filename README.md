
# react-native-didomi

## Getting started

`$ npm install react-native-didomi --save`

### Mostly automatic installation

`$ react-native link react-native-didomi`

### Manual installation


#### iOS

1. In XCode, in the project navigator, right click `Libraries` ➜ `Add Files to [your project's name]`
2. Go to `node_modules` ➜ `react-native-didomi` and add `RNDidomi.xcodeproj`
3. In XCode, in the project navigator, select your project. Add `libRNDidomi.a` to your project's `Build Phases` ➜ `Link Binary With Libraries`
4. Run your project (`Cmd+R`)<

#### Android

1. Open up `android/app/src/main/java/[...]/MainActivity.java`
  - Add `import com.reactlibrary.RNDidomiPackage;` to the imports at the top of the file
  - Add `new RNDidomiPackage()` to the list returned by the `getPackages()` method
2. Append the following lines to `android/settings.gradle`:
  	```
  	include ':react-native-didomi'
  	project(':react-native-didomi').projectDir = new File(rootProject.projectDir, 	'../node_modules/react-native-didomi/android')
  	```
3. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
  	```
      compile project(':react-native-didomi')
  	```

#### Windows
[Read it! :D](https://github.com/ReactWindows/react-native)

1. In Visual Studio add the `RNDidomi.sln` in `node_modules/react-native-didomi/windows/RNDidomi.sln` folder to their solution, reference from their app.
2. Open up your `MainPage.cs` app
  - Add `using Didomi.RNDidomi;` to the usings at the top of the file
  - Add `new RNDidomiPackage()` to the `List<IReactPackage>` returned by the `Packages` method


## Usage
```javascript
import RNDidomi from 'react-native-didomi';

// TODO: What to do with the module?
RNDidomi;
```
  
