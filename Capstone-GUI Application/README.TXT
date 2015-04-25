PROJECT TITLE:Location Informer
PURPOSE OF PROJECT:The give general purpose information about a location 
VERSION or DATE: 24 April 2015
DEPENDENCIES: Incorporates JSoup, should be in the Github folder
HOW TO START THIS PROJECT:Run the main method from the WindowViewer class
AUTHORS: Nikhil Sivapatham
USER INSTRUCTIONS:

So this class was basically created to provide information about a location given the adress. It was not
too broadly defined when I started it out, but I think I have the most important aspect done now. Luckily
there is an almost infinite ammount of room for growth such as adding reviews from a website such as
Yelp, and maybe even doing something in the future such as an live twitter feed about this location.

To run the program, you simply run the main method on the WindowViewer.
There is an information drop-down method that will provide the format for typing in the adress.
Does not fully work with a street adress, only shows the map.

Some locations to try:
Naperville North,Naperville,IL
Naperville Central,Naperville,IL
Statue of Liberty,New York,NY
Golden Gate Bridge,San Francisco,CA
Eiffel Tower,Paris,France

There is some flexibility between states and countries, due to Google's flexibility, but for best results,
within the US, use state names

This project synthesize many of the units we have learned this year:

Object Oriented design As I have multiple Classes and I had to figure out how to best optimize them
and what to write in each class

Inheritance and Polymorphism incroporated with GUI alot of java swing and awt components I used extended
a superclass like my WindowFrame extending JFrame, so I had to work with inheritance.

Inner Classes were also used for my mouse listern for my one JButton

Arrays and ArrayLists were used extensively for parsing through strings and putting them into the right
format for a URL 

For loops and if loops were used for tons of things because this is programming

Static methods were utilized in Objects that didn't really need classes built for their usage

Catching and throwing excpetions were used, albeit sparsely when using online content 

I also had to learn some new things and do research for my project and to learn more about programming in
general:

I had to learn how to use GUI managers, and in this case I chose GridBagLayout because it is very powerfull

I also had to use a 3rd party library, JSoup, so that was good practice for the future

I learned a little bit about using apis, though it was admitedly mostly just url manipulation

I learned about new JComponents like JScrollable etc.

I have learned have hard it is to write a somewhat functioning program,but I have learned well


