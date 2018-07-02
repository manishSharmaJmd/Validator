A simple library which can be used to validate edittext in android for empty values.

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
	        implementation 'com.github.manishSharmaJmd:Validator:1.4'
	     }
```

How to use it :-
```android
Step 1 :- Call Validator.attachValidator(EditText[] editTextAr, TextWatcher textWatcher, View.OnFocusChangeListener onFocusChangeListener)
```

```android
editTextAr = Array of Edittext that required validation.
textWatcher = Pass TextWatcher callback for lookup text change.
onFocusChangeListener = Pass OnFocusChangeListener callback to get focus info.
```

```android
Setup 2 :- Check for success result Validator.isValidated()
```

**Advanced Usage :-**


Step 1 :- 

Inject into Activity. It will pick all edittext automatically.

```android
Validator.injectActivity(Activity activity,  TextWatcher textWatcher,  View.OnFocusChangeListener onFocusChangeListener);
 
```
Inject into Fragment. It will pick all edittext automatically.

```android
Validator.injectFragment(Fragment fragment,  TextWatcher textWatcher,  View.OnFocusChangeListener onFocusChangeListener)
  ```

Setup 2 :-
```android
Check for success result Validator.isValidated()
```
To change error style, Pass resource id like this :-
```android
Validator.setErrorResource(int resId)
```

Enjoy!