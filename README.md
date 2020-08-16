# SpringBootSample

# WebApp
* Web demo：https://np-springboot.herokuapp.com/

# API
* API demo：https://np-springboot.herokuapp.com/v1/api/judge
* リクエストパラメータ：
```yaml
{
   "check_data":[
      {
         "name":"とがみん",
         "type":"human"
      },
      {
         "name":"ペンギン",
         "type":"animal"
      },
      {
         "name":"ぶた",
         "type":"animal"
      }
   ]
}
```
* レスポンス：
```yaml
{
    "count": 1,
    "results": [
        {
            "name": "とがみん",
            "type": "human"
        }
    ]
}
```

# Library：
> Lombok
 * Lombokを公式からダウンロード：https://projectlombok.org/download
 * ダウンロードフォルダーに移動して、コマンドを実行する：`$ java -jar lombok.jar`
