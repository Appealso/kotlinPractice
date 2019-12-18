from urllib.request import urlopen
import pandas as pd
from bs4 import BeautifulSoup
import webbrowser

API_KEY=""
company_code="014680"

url = "http://dart.fss.or.kr/api/search.xml?auth="+API_KEY+"&crp_cd="+company_code+"&start_dt=19990101&bsn_tp=A001&bsn_tp=A002&bsn_tp=A003"
resultXML=urlopen(url)
result=resultXML.read()

xmlsoup=BeautifulSoup(result,'html.parser')

print(xmlsoup)

data = pd.DataFrame()

te=xmlsoup.findAll("list")

for t in te:
    temp=pd.DataFrame(([[t.crp_cls.string,t.crp_nm.string,t.crp_cd.string,t.rpt_nm.string,
        t.rcp_no.string,t.flr_nm.string,t.rcp_dt.string, t.rmk.string]]),
        columns=["crp_cls","crp_nm","crp_cd","rpt_nm","rcp_no","flr_nm","rcp_dt","rmk"])
    data=pd.concat([data,temp])

print(data)

data=data.reset_index(drop=True)
url2="http://dart.fss.or.kr/dsaf001/main.do?rcpNo="+data['rcp_no'][0]

webbrowser.open(url2)