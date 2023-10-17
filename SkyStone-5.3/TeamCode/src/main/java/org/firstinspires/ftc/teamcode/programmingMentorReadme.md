Hey,

If you are reading this, you must must be curious on the thought process and construction of this
code. This code was built for the FIRST Tech Challenge 2019-2020 challenge SKYSTONE.

This project is programmed in Java. To get the years project you must go to the FIRST Tech Challenge
GitHub and download the years project. There are steps online and on YouTube about how to download
and import it into Android Studio. Make sure before you do this that you have the latest version of
plugins for Android Studio because if you try to update them later, the code may break.

Some information about the project. Once successfully installed, their should be two folders on the
left of the screen (unless they really change stuff). FtcRobotController has a bunch of helpful
examples under it on how to do basic to more complex tasks. If ever you have a question on how to do
something, I recommend looking there first. The team code folder is what will get uploaded to the
robot. This is where you will put all of your code for the robot.

Some other information that will be helpful to you is that for vision tracking the last two years,
we used a library called Doge.CV. The developers for this are really easy to work with if you have
questions and need to contact them. The game specific vision tacking is usually available for teams
to use around October. To download Doge.CV you must go to their GitHub page and follow the download
instructions (scroll down on the page or find the .readme file). A team called Wizards.exe usually
release a tutorial video that shows how to use it for the years game. Remember, some games their is
an easier way to solve the problem than vision tracking, but sometimes it is necessary to complete
the task.

The main difference from this project code compared to the 2018-2019 one is the file called
robotMap (even though the file really should just be called robot). THIS SIMPLIFIES LIFE A TON, BUT
CAN BE HARD FOR MIDDLE SCHOOL STUDENTS TO RAP THEIR HEAD AROUND. This file is heavily commented so
one can follow what is happening. Basically we have a bunch of constant values that we can use
throughout the code so instead of changing a value in every file, you can just do it in one. It also
has the HardwareMap all in it, so in the top of each file all you have to do is init the robotMap.
Finally, we have some functions at the bottom of the file to help with autonomous programming. These
functions are really useful for drivetrain movement (how it is set up right now) and could be used
to use encoder values for other things such as elevators. The math behind it will probably have to
be modified for a given application.

If you have any questions, feel free to reach out to me and I will try to help as best I can, the
goal however, is for the team to be self-sufficient (which I kinda failed at doing this year) and
allow the members of the programming group to work through problems, learn from their mistakes, and
make it so programmers joining the high school robotics team are more prepared than I was when I
joined the team in 2017.

Thanks,

Darren Seubert
WARPSPEED 4239
2 Year Captain (FRC), 4 Year Lead Programmer (FRC), 4 Year Driver (FRC), 2 Year Programming Mentor (FTC)