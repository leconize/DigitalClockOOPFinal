# DigitalClockOOPFinal

## โจทย์
ในข้อนี้ของรุ่นพี่ให้ใช้swing สร้าง gui ของนาฬิกา Digital ของหลายๆTimezone
แต่เรื่องไม่ได้ว่าอาจารย์ให้เอา Timezone ที่ไหนบ้างจึงเลือกทำแค่ ไทย, ญี่ปุ่น, อังกฤษ

## อธิบาย

มี3 class คือ Main, DigitalCLock, ClockTimer

Main เป็น class สำหรับ runner

DigitalClock เป็น class extends มาจาก Jframe ไว้เป็น GUI ซึ่งภายใน Digital Clock นั้นจะมีการเรียก ClockTimer เพื่อเป็นLogic สำหรับจัดการเวลา ของนาฬิกาข้างใน 

ClockTimer เป็น class Thread เพื่อจัดการตั้งเวลาของแต่ละTimeZone ภายใน Method run() จะเป็น loop while(true) ที่ข้างในจะทำการ ทำการตั้งเวลาให้นาฬิกาของเรา


```java
    ClockTimer(JLabel timeLabel, String timezone){
        simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone(timezone));
        this.town = timezone;
        this.timeJLabel = timeLabel;
    }
```

เมื่อดูใน constructor ของ class ClockTimer จะเห็นว่ามีการ setTimeZone
ถ้าอยากรู้เราจะต้องเขียน ชื่อ Timezone ของประเทศนั้นๆอย่างไร
สามารถไปดูใน [ลิ้งนี้](https://www.mkyong.com/java/java-display-list-of-timezone-with-gmt/)

หรือใช้ code ชุดนี้ ซึ่งอยู่ในลิ้งข้างบน 555555
```java
public static void main(String[] args) {

	String[] ids = TimeZone.getAvailableIDs();
	for (String id : ids) {
		System.out.println(displayTimeZone(TimeZone.getTimeZone(id)));
	    }

	System.out.println("\nTotal TimeZone ID " + ids.length);

	}

	private static String displayTimeZone(TimeZone tz) {

		long hours = TimeUnit.MILLISECONDS.toHours(tz.getRawOffset());
		long minutes = TimeUnit.MILLISECONDS.toMinutes(tz.getRawOffset())
                                  - TimeUnit.HOURS.toMinutes(hours);
		// avoid -4:-30 issue
		minutes = Math.abs(minutes);

		String result = "";
		if (hours > 0) {
			result = String.format("(GMT+%d:%02d) %s", hours, minutes, tz.getID());
		} else {
			result = String.format("(GMT%d:%02d) %s", hours, minutes, tz.getID());
		}

		return result;

	}
```

สำหรับบางที่ไม่อยากทำแบบนี้อาจแก้ปัญหาด้วยวิธีอื่นเช่นการ+current Time ด้วย GMT ของเราหากรู้ความต่างช่วงของเวลาแต่ไม่เขียนให้ดูนะหัดทำเอง


## ข้ออื่น
ข้อ [histrogram](https://github.com/tomhero/FinalOOP60Histogram) by  [TD พี่ต้อมสุดcool](https://www.facebook.com/chayut.ruksomya) 

ข้อ [เปิดไฟล์และเขียนไฟล์](https://github.com/madooding/Java-Notepad--) by [TA ดิ่ง](https://www.facebook.com/madooding)


เขียนโดย [TA กาจ](https://www.facebook.com/gadkad)

QC by พี่บัว
