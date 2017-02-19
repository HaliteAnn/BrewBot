# BrewBot
A bot for Baldwin's Brew on Flight Rising.

## Using BrewBot

### Downloading
BrewBot can be downloaded from the following location: (link yet to be added)

When you download BrewBot, you will receive two files:
* A jar file that holds the updated application
* BrewBot.bat, which runs the application

Make sure that you keep these two files together, in the same folder.

### Setting up

Before you run BrewBot, you should set your computer up in the following manner:

* Open Baldwin's Brew and navigate to the "Transmute Objects" page
* Make sure that your browser window is maximized, and on your primary monitor (if you have multiple)
* Make sure that the page is scrolled all the way up to the top--if you scroll down even a little bit, the bot may get a bit confused as to where the buttons are.

### Running the application
To run BrewBot, simply double-click on BrewBot.bat.  You can quit the application by selecting the command promt and using Ctrl-C.

## Requirements
BrewBot can only be run on Windows machines.

Only certain screen resolutions are supported.  I will continue to test and add more over time.  Please refer to the list below for currently supported dimensions.  You can check the resolution of your monitor in your display settings.

### Supported screen resolutions:
* 1920 x 1080

# FAQ

### Can the admins detect BrewBot?
Simply put, no.  BrewBot does not interact with your internet browser directly the way WebDriver or other bot-friendly APIs might.  Instead, BrewBot takes control of your keyboard and mouse and uses them like a human does!  Because of this, there is no way for the admins to resonably detect the use of BrewBot--it's as if you're doing the clicking yourself.

With that said, I would not recommend running this application 24/7.  Any admin would be rightfully suspicious of someone who manages to brew every 30-45 minutes for several days straight without sleep.

### Can I run BrewBot while I'm actively using my computer for other things?
No.  While BrewBot is running, the Baldwin's Brew page must remain as the primary window on your monitor, and should stay maximized.  Because BrewBot moves your cursor around and clicks, it won't work very well to try to use your computer for other things while it's active.  The only time I recommend using your cursor yourself while BrewBot is running is to exit it.

This is why BrewBot is recommended for while you're away at work--it can do its thing while you wouldn't be using your computer anyways!

### Can I leave BrewBot running overnight?
I wouldn't recommend it.  Once rollover comes around, you will be automatically logged out of the site, and BrewBot will end up just randomly clicking around on the logout page.  It will not click any other links or do anything harmful, so if you forget about it and do leave it running that's okay.  But it won't be of much use.

### Does BrewBot always brew immediately after the last item is done?  Isn't that suspicious?
Once BrewBot puts an item into Baldwin's Brew, it waits anywhere between 32 - 45 minutes before trying again.  This random timer allows BrewBot to appear like a real person who just happens to check in a lot!  Mouse clicks are also randomly timed--they will never spam requests to the site, and always maintain a human-like delay.

