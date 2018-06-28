
**GRADLE** :- 
Add it in your root build.gradle at the end of repositories:

```
allprojects {
	repositories {
			maven { url 'https://jitpack.io' 
			}
		     }
	      }
  ```
 Add it in your app build.gradle at the end of repositories:
 
```
dependencies {
	        implementation 'com.github.manishSharmaJmd:Validator:1.2'
	     }
```

How to use it :-
```android
Step 1 :- Call Validator.attachValidator(EditText[] editTextAr, final TextWatcher textWatcher, final View.OnFocusChangeListener onFocusChangeListener)
```

```android
editTextAr = Array of Edittext that required validation.
textWatcher = Pass TextWatcher callback for lookup text change.
onFocusChangeListener = Pass OnFocusChangeListener callback to get focus info.
```

```android
Setup 2 :- Check for success result Validator.isValidated()
```

