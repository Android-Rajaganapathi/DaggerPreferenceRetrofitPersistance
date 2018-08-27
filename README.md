# DaggerPreferenceRetrofitPersistance
An application with Dagger 2, shared preference, retrofit API  and Room storage. Each and every concept is implemented in separate activity for beginners.  

>### In my previous Git repo I have provide Dagger 2 in simple steps. It is available [here][1].

Here in this repo I've used shared preference, API calling(Retrofit) and persistance storage(Room DB) with the help of dependency injection(Dagger 2). 

------------
### Lets pop into the code:
* _`SimpleActivity.java:`_ - for simple `Dagger 2` introduction and basic functionality (info available [here][1])

* _`PreferenceActivity.java:`_ - for storing and retriving data from `SharedPreferences`

Preferences and utils will be injected through dagger component.

* _`NetworkActivity.java:`_ - for calling API using `Retrofit`

Retrofit setup and call is done in NetworkModule and injected in activity thought dagger.

* _`PersistenceActivity.java:`_ - for storing and retriving data from `Room `

Room setup and DAO is defined in PersistenceModule and injected in activity thought dagger.

Each specific component holds an respective custom scopes.

[1]: https://github.com/Android-Rajaganapathi/Simple-Dagger-2
