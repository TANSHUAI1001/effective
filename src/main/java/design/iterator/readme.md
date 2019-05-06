迭代器（Iterator）模式，又叫做游标（Cursor）模式。
可以看作游标在元素的前面，上一个元素的后面。
next()游标加一，返回前一个的值。
```
cursor = i + 1;
return (E) elementData[lastRet = i];
```
