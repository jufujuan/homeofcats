package jfj.homeofcars.model.bean;

import java.util.List;

/**
 *搜索界面关键字的实体类
 */
public class KeyBean {

    /**
     * returncode : 0
     * message :
     * result : {"pageindex":1,"pagesize":0,"pagecount":1,"rowcount":10,"wordlist":[{"id":0,"name":"奥迪"},{"id":370,"name":"奥迪A3(进口)"},{"id":3554,"name":"昂科威"},{"id":18,"name":"奥迪A6L"},{"id":692,"name":"奥迪A4L"},{"id":3154,"name":"阿特兹"},{"id":3405,"name":"艾瑞泽5"},{"id":812,"name":"奥迪Q5"},{"id":3170,"name":"奥迪A3"},{"id":2951,"name":"奥迪Q3"}]}
     */

    private int returncode;
    private String message;
    /**
     * pageindex : 1
     * pagesize : 0
     * pagecount : 1
     * rowcount : 10
     * wordlist : [{"id":0,"name":"奥迪"},{"id":370,"name":"奥迪A3(进口)"},{"id":3554,"name":"昂科威"},{"id":18,"name":"奥迪A6L"},{"id":692,"name":"奥迪A4L"},{"id":3154,"name":"阿特兹"},{"id":3405,"name":"艾瑞泽5"},{"id":812,"name":"奥迪Q5"},{"id":3170,"name":"奥迪A3"},{"id":2951,"name":"奥迪Q3"}]
     */

    private ResultBean result;

    public int getReturncode() {
        return returncode;
    }

    public void setReturncode(int returncode) {
        this.returncode = returncode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean {
        private int pageindex;
        private int pagesize;
        private int pagecount;
        private int rowcount;
        /**
         * id : 0
         * name : 奥迪
         */

        private List<WordlistBean> wordlist;

        public int getPageindex() {
            return pageindex;
        }

        public void setPageindex(int pageindex) {
            this.pageindex = pageindex;
        }

        public int getPagesize() {
            return pagesize;
        }

        public void setPagesize(int pagesize) {
            this.pagesize = pagesize;
        }

        public int getPagecount() {
            return pagecount;
        }

        public void setPagecount(int pagecount) {
            this.pagecount = pagecount;
        }

        public int getRowcount() {
            return rowcount;
        }

        public void setRowcount(int rowcount) {
            this.rowcount = rowcount;
        }

        public List<WordlistBean> getWordlist() {
            return wordlist;
        }

        public void setWordlist(List<WordlistBean> wordlist) {
            this.wordlist = wordlist;
        }

        public static class WordlistBean {
            private int id;
            private String name;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }
    }
}
