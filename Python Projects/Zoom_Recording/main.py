from datetime import datetime as date
from pynput.keyboard import Key, Controller
import webbrowser
import time

# __________________________________________Getting current time and day________________________________________________

day = date.now().strftime("%A")                                         # Getting current day
hour = date.now().time().hour                                           # Getting current hour
minute = date.now().time().minute                                       # Getting current minute
keyboard = Controller()

schedule_times = ["08:55", "11:00", "15:20", "15:21", "21:08"]          # Times to start recording
end_times = ["13:05", "11:05", "23:07", "23:08", "23:09"]               # Time to end recording
end = '23:55'                                                           # Standard time to exit the program
one_hour = 3900
two_hours = 7440


def full_time(numb):
    if numb < 10:                                                       # Getting correct time format format("hh:mm")
        return str(hour) + ':0' + str(minute)
    else:
        return str(hour) + ':' + str(minute)


current_time = full_time(minute)                                        # Getting correct time format format("hh:mm)

while current_time != end:

    url = None
    time_of_record = None

    # ____________________________________________Getting the correct url_______________________________________________

    if day == "Monday":
        end = end_times[0]
        if schedule_times[0] == current_time:                                                               # θεωρία πιθανοτήτων
            time_of_record = two_hours
            url = 'https://tuc-gr.zoom.us/j/93295909345?pwd=NnM1QTlqRnNoMVY2UEgvdzc2aFRCdz09'
        elif schedule_times[1] == current_time:                                                             # Ανάλυση Ηλεκτρικών Κυκλωμάτων
            time_of_record = two_hours
            url = 'https://tuc-gr.zoom.us/j/92241929334?pwd=R3RESHVQWWl6WC8vTUcvUEROTW9sUT09#success'

    elif day == "Tuesday":
        end = end_times[0]
        if schedule_times[1] == current_time:
            time_of_record = two_hours
            url = 'youtube.com'
        elif schedule_times[2] == current_time:
            time_of_record = two_hours
            url = 'facebook.com'

    elif day == "Wednesday":
        end = end_times[3]
        if schedule_times[1] == current_time:
            time_of_record = 2700
            url = 'youtube.com'
        elif schedule_times[2] == current_time:
            time_of_record = 2700
            url = 'facebook.com'

    elif day == "Thursday":
        end = end_times[4]

        if schedule_times[1] == current_time:
            time_of_record = 2700
            url = 'youtube.com'
        elif schedule_times[2] == current_time:
            time_of_record = 2700
            url = 'facebook.com'

    elif day == "Friday":
        end = end_times[5]

        if schedule_times[1] == current_time:
            time_of_record = 2700
            url = 'youtube.com'
        elif schedule_times[2] == current_time:
            time_of_record = 2700
            url = 'facebook.com'

    if url is None:                                                     # If its a day of the weekend the program stops
        exit()

    def start_stop():                                                   # Starting / Stopping recording
        keyboard.press(Key.f9)
        keyboard.release(Key.f9)

    def alt_tab():                                                      # Alt-tabing
        keyboard.press(Key.alt)
        keyboard.press(Key.tab)
        keyboard.release(Key.alt)
        keyboard.release(Key.tab)

    def alt_f4():                                                       # Alt-tabing
        keyboard.press(Key.alt)
        keyboard.press(Key.f4)
        keyboard.release(Key.alt)
        keyboard.release(Key.f4)

    # _________________________________________________Opening zoom_____________________________________________________

    webbrowser.register('chrome', None, webbrowser.BackgroundBrowser(
        "C://Program Files (x86)//Google//Chrome//Application//chrome.exe"))
    webbrowser.get('chrome').open(url)
    time.sleep(10)                                                      # Delay for the program to open

    # _________________________________________________Opening obs______________________________________________________

    keyboard.press(Key.cmd)                                             # Opening obs
    keyboard.press('5')
    keyboard.release(Key.cmd)
    keyboard.release('5')
    time.sleep(10)                                                      # Delay for the program to open
    start_stop()                                                        # Start recording
    time.sleep(2)                                                       # Delay to ensure the recording has started
    alt_tab()                                                           # Alt-tabing to show the zoom conference
    time.sleep(time_of_record)                                          # Record for x amount of time

    # _________________________________________________Closing zoom_____________________________________________________

    alt_f4()                                                            # Closing zoom

    # _________________________________________________Closing obs______________________________________________________

    alt_tab()                                                           # Alt-tabing to show the obs
    time.sleep(2)                                                       # Delay to ensure the obs is selected
    start_stop()                                                        # Stop recording
    time.sleep(2)                                                       # Delay to ensure the recording has stopped
    alt_f4()                                                            # Closing obs

    # ______________________________________________New information_____________________________________________________

    hour = date.now().time().hour
    minute = date.now().time().minute
    current_time = full_time(minute)                                    # Getting correct time format format("hh:mm)
    time.sleep(5)
