# druid-learn
druid学习笔记

数据存储格式：<br>
（1）通用存储格式 GenericIndexed/GenericIndexedWriter，可以Streams方式生成。<br>
分两部分：header/values, header存offset，values存实际的数据，所以根据index可以很快定位到读取出所在位置的数据。<br>
写的时候是两个文件单独生成，最后面会把两个文件合到一起，加上一个头部meta文件。<br>
（2）
