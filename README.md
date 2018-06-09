# Android-Kotlin
Android app written in Kotlin language.

# Fragment Component

1. Create a Sample Fragment and uncheck factory methods and interface callbacks. It gives us just one method 
  ```
override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                          savedInstanceState: Bundle?): View? {
    // Inflate the layout for this fragment
    return inflater.inflate(R.layout.fragment_sample, container, false)
}
  ``` 
  
2. The below function provides a single instance of the fragment
```
companion object {
    fun newInstance() : SampleFragment {
        return SampleFragment()
    }
}
```

3. Lets add our SampleFragment to the MainActivity
```
if(savedInstanceState == null) {
    supportFragmentManager
            .beginTransaction()
            .add(R.id.root_layout, SampleFragment.newInstance(), "samplefragment")
            .commit()
}
```
IF condition to check if instance of activity is saved or not, if yes then new instance of fragment is not created.

## The following lifecycle events come into play when you add a fragment:

#### onAttach: 
When the fragment attaches to its host activity.

#### onCreate: 
When a new fragment instance initializes, which always happens after it attaches to the host — fragments are a bit like viruses.

#### onCreateView: 
When a fragment creates its portion of the view hierarchy, which is added to its activity’s view hierarchy.

#### onActivityCreated: 
When the fragment’s activity has finished its own onCreate event.

#### onStart: 
When the fragment is visible; a fragment starts only after its activity starts and often starts immediately after its activity does.

#### onResume: 
When the fragment is visible and interactable; a fragment resumes only after its activity resumes and often resumes immediately after the activity does.

#### onPause: 
When the fragment is no longer interactable; this occurs when either the fragment is about to be removed or replaced or when the fragment’s activity pauses.

#### onStop: 
When the fragment is no longer visible; this occurs either after the fragment is about to be removed or replaced or when the fragment’s activity stops.

#### onDestroyView: 
When the view and related resources created in onCreateView are removed from the activity’s view hierarchy and destroyed.

#### onDestroy: 
When the fragment does its final clean up.

#### onDetach: 
When the fragment is detached from its activity.
