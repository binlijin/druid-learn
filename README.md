# druid-learn
druid学习笔记

数据存储格式：<br>
（1）通用存储格式 GenericIndexed/GenericIndexedWriter，可以Streams方式生成。<br>
分两部分：header/values, header存offset，values存实际的数据，所以根据index可以很快定位到读取出所在位置的数据。<br>
写的时候是两个文件单独生成，最后面会把两个文件合到一起，加上一个头部meta文件。<br>
（2）time column存储成CompressedLongs 65536/8=8192 <br>
详见CompressedLongsIndexedSupplier，默认LZ4压缩，底层基于GenericIndexed格式，但是做了压缩。
详细存储格式:<br>
  分成8192个long一段，这8192个long使用LZ4压缩(https://github.com/jpountz/lz4-java), 压缩完后,写到GenericIndexed里。<br>
  读取的时候先根据index/8192算出来在那个段里面，然后index%8192算出在这个段里面的偏移，最终获取到数据。
（3）metrics column

