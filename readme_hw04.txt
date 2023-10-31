My program VideoPlayer.java emulates playing a video, represented by an array of Strings containing all the steps of the classical narritive structure The Hero's Journey that the program will present based on the inputs of the user.

The program utilizes the State Design Pattern via 4 states the player can be in: VideoPaused, VideoPlaying, Sleeping, and VideoOver. The user has 2 functions they can call to interact with the player: pressPlayPause() and watch().

From the VideoPaused state, calling pressPlayPause() will change the state to VideoPlaying and advance the video 1 step. Calling watch() will change the state to Sleeping.

From the VideoPlaying state, calling pressPlayPause() will change the state to VideoPaused. Calling watch() will maintain the state and advance the video.

From the Sleeping state, calling pressPlayPause() will change the state to VideoPlaying and advance the movie. Calling watch() will cause nothing to happen.

If at any point when the video is advanced, it reaches the end of the array, the program will divert from its usual response and instead change state to VideoOver. From here, calling pressPlayPause() will reset the video's progress and set the state to VideoPlaying. Calling watch() instead will set the state to Sleeping.