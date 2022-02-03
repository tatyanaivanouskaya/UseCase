
Hi everyone. This is a small project where I've tried to use Clean Architecture, MVVM, Koin, Dagger (dagger branch), Hilt (Hilt branch).

It works like this: if you enter your name into "Put data here" and press "Save data" button you'll get "Save result = true" into text field above the "Get data" button.
If you press "Get data" button you'll get your saved name and "def_last_name".

The main project's aim is dividing code into three modules: app, domain, data. 
The app module is the entry point of application and contains the UI logic.
The domain module is completely independent from other modules.
The data module contains information about data storage.



 
