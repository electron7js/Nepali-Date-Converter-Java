# Nepali Date Converter

Nepali date converter written in base java

For now,
converts English date into Nepali date, from 1918 to 2043 AD
Nepali date to english date, from 1975 to 2099 BS
And number of days between dates

## Usage

String nepaliDate = NepaliDate.getNepaliDate("2002-07-23");
Accepts "YYYY-MM-DD" string, LocalDate, and java.sql.Date
Returns String "YYYY-MM-DD"

Date englishDate = NepaliDate.getEnglishDate(2059,04,07);

Integer daysBetween = NepaliDate.getDaysBetween(2000,1,1,2059,04,07);