package top.simple.stark.java8.date;

import org.junit.jupiter.api.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.time.zone.ZoneRulesProvider;

public class NewDateTest {

    @Test
    public void test1() throws InterruptedException {
        Instant now = Instant.now();
        // 时间戳
        System.out.println("当前时间戳(秒级)：" + now.getEpochSecond());
        System.out.println("当前时间戳(毫秒级)：" + now.toEpochMilli());
        // 计算操作时间
        Instant start = Instant.now();
        System.out.println("开始时间戳(秒级)：" + start.getEpochSecond());

        Thread.sleep(3000);

        Instant end = Instant.now();
        System.out.println("结束时间戳(秒级)：" + end.getEpochSecond());
        Duration between = Duration.between(start, end);
        System.out.println("操作时间：" + between.getSeconds());
    }

@Test
public void Test2() {
    Instant now = Instant.now();
    // 时间戳转换为日历时间（UTC时区）
    ZonedDateTime dtUTC = ZonedDateTime.ofInstant(now, ZoneId.of("UTC"));
    ZonedDateTime dtsh = ZonedDateTime.ofInstant(now, ZoneId.systemDefault());
    System.out.println(" 时间戳转换为日历时间（UTC时区）" + dtUTC);
    System.out.println(" 时间戳转换为日历时间（默认时区）" + dtsh);
    System.out.println("日历时间转换为时间戳（默认时区）" + ZonedDateTime.now().toInstant().getEpochSecond());
    System.out.println("时区列表：" + ZoneRulesProvider.getAvailableZoneIds());

    // 日期转换
    DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    String dateStr = df.format(dtsh);
    System.out.println("日期格式化为字符串：" + dateStr);
    DateTimeFormatter df1 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ssxx");
    String dateStr1 = df1.format(dtsh);
    System.out.println("字符串转换为日期：" + ZonedDateTime.parse(dateStr1,df1));

    System.out.println("下个周五：" + dtsh.with(TemporalAdjusters.next(DayOfWeek.FRIDAY)));
    System.out.println("本月第一天：" + dtsh.with(TemporalAdjusters.firstDayOfMonth()));
}
}
