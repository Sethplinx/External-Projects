import os
import time
import datetime

today_time = datetime.datetime.today()

for curr_file in os.listdir("C:/Users/Alex/Downloads"):
    if curr_file != "desktop.ini":
        os.chdir("C:/Users/Alex/Downloads")
        f_date = datetime.datetime.strptime(time.ctime(os.path.getmtime(curr_file)), "%a %b %d %H:%M:%S %Y")
        dif_time = f_date + datetime.timedelta(days=20)
        if today_time > dif_time:
            os.remove(curr_file)
