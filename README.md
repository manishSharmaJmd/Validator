
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
	        implementation 'com.github.manishSharmaJmd:Validator:1.3'
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

Advanced Usage :-

Inject into Activity. It will pick all edittext automatically.

```android
Validator.injectActivity(Activity activity, final TextWatcher textWatcher, final View.OnFocusChangeListener onFocusChangeListener);
 
```
Inject into Fragment. It will pick all edittext automatically.

```android
Validator.injectFragment(Fragment fragment, final TextWatcher textWatcher, final View.OnFocusChangeListener onFocusChangeListener)
  ```
To change error style, Pass resource id like this :-
```android
Validator.setErrorResource(int resId)
```
