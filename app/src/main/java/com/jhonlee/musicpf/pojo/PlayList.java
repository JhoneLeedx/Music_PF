package com.jhonlee.musicpf.pojo;

import java.util.List;

/**
 * Created by JhoneLee on 2017/3/22.
 */

public class PlayList {


    /**
     * playlists : [{"id":150588659,"name":"年度最受欢迎个性推荐歌曲","coverImgUrl":"http://p4.music.126.net/EOEDthc160K57snhlp96-g==/1364493965978189.jpg","creator":{"nickname":"网易云音乐","userId":1,"userType":3,"authStatus":1},"subscribed":false,"trackCount":70,"userId":1,"playCount":29700526,"bookCount":713010,"highQuality":false},{"id":555155176,"name":"2016年度最受欢迎个性推荐歌曲","coverImgUrl":"http://p4.music.126.net/ZUoCW3KI5MmPGToRYsl7jA==/18542164092501777.jpg","creator":{"nickname":"网易云音乐","userId":1,"userType":3,"authStatus":1},"subscribed":false,"trackCount":99,"userId":1,"playCount":13071548,"bookCount":267722,"highQuality":false},{"id":19820015,"name":"100首古风歌曲推荐❶【古风控必备】","coverImgUrl":"http://p4.music.126.net/0qa7W8CGaSix-ot5g_JpIQ==/6009930558058987.jpg","creator":{"nickname":"米虫-小蚊子丶一只呆雯纸","userId":896790,"userType":0,"authStatus":1},"subscribed":false,"trackCount":100,"userId":896790,"playCount":7772461,"bookCount":348216,"highQuality":true},{"id":20320734,"name":"最令人难忘的100首古风歌曲【推荐❷】","coverImgUrl":"http://p3.music.126.net/WrHARkWHsaBlBBMS21TZhQ==/6030821279003241.jpg","creator":{"nickname":"米虫-小蚊子丶一只呆雯纸","userId":896790,"userType":0,"authStatus":1},"subscribed":false,"trackCount":100,"userId":896790,"playCount":2940347,"bookCount":142196,"highQuality":false},{"id":11803820,"name":"推荐民谣50曲","coverImgUrl":"http://p4.music.126.net/L8BlzhQJsCbUqiW1y0ZVFQ==/5997835929691089.jpg","creator":{"nickname":"我们的民谣","userId":11674806,"userType":0,"authStatus":0},"subscribed":false,"trackCount":50,"userId":11674806,"playCount":3304436,"bookCount":53145,"highQuality":false},{"id":361976079,"name":"『日系男毒推荐』耳朵会怀孕，直男会弯。①","coverImgUrl":"http://p4.music.126.net/JZX_mz6MDRc30Jh0lukjsA==/1401877331585192.jpg","creator":{"nickname":"佐仓小小千代","userId":81635197,"userType":0,"authStatus":0},"subscribed":false,"trackCount":33,"userId":81635197,"playCount":1961986,"bookCount":81968,"highQuality":false},{"id":41302713,"name":"知乎推荐入门级古典音乐","coverImgUrl":"http://p4.music.126.net/CQmRnZt33mDMsXKabTkbKw==/7832920836287934.jpg","creator":{"nickname":"RexLRP","userId":392759,"userType":0,"authStatus":0},"subscribed":false,"trackCount":82,"userId":392759,"playCount":995703,"bookCount":84525,"highQuality":false},{"id":454470674,"name":"八月最IN电子音乐推荐","coverImgUrl":"http://p4.music.126.net/xXGs2lW7xsxexG4kyiYg2w==/18611433323536031.jpg","creator":{"nickname":"welphenEDM","userId":55535424,"userType":2,"authStatus":1},"subscribed":false,"trackCount":118,"userId":55535424,"playCount":2792266,"bookCount":31860,"highQuality":false},{"id":372786645,"name":"四月最IN电子音乐推荐","coverImgUrl":"http://p4.music.126.net/2i8rWK496D4lb9bYmZ36lQ==/3311729026666978.jpg","creator":{"nickname":"welphenEDM","userId":55535424,"userType":2,"authStatus":1},"subscribed":false,"trackCount":66,"userId":55535424,"playCount":1999031,"bookCount":35982,"highQuality":false},{"id":40468930,"name":"【英文歌推荐】","coverImgUrl":"http://p3.music.126.net/SUOVv6VQ4PS8AyF3Fimb9Q==/2919203372278795.jpg","creator":{"nickname":"F1ND_Y0USELF","userId":34515414,"userType":0,"authStatus":0},"subscribed":false,"trackCount":423,"userId":34515414,"playCount":1601111,"bookCount":30659,"highQuality":false}]
     * playlistCount : 200
     */

    private int playlistCount;
    private List<PlaylistBean> playlists;

    public int getPlaylistCount() {
        return playlistCount;
    }

    public void setPlaylistCount(int playlistCount) {
        this.playlistCount = playlistCount;
    }

    public List<PlaylistBean> getPlaylists() {
        return playlists;
    }

    public void setPlaylists(List<PlaylistBean> playlists) {
        this.playlists = playlists;
    }

    public static class PlaylistBean {
        /**
         * id : 150588659
         * name : 年度最受欢迎个性推荐歌曲
         * coverImgUrl : http://p4.music.126.net/EOEDthc160K57snhlp96-g==/1364493965978189.jpg
         * creator : {"nickname":"网易云音乐","userId":1,"userType":3,"authStatus":1}
         * subscribed : false
         * trackCount : 70
         * userId : 1
         * playCount : 29700526
         * bookCount : 713010
         * highQuality : false
         */

        private int id;
        private String name;
        private String coverImgUrl;
        private CreatorBean creator;
        private boolean subscribed;
        private int trackCount;
        private int userId;
        private int playCount;
        private int bookCount;
        private boolean highQuality;

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

        public String getCoverImgUrl() {
            return coverImgUrl;
        }

        public void setCoverImgUrl(String coverImgUrl) {
            this.coverImgUrl = coverImgUrl;
        }

        public CreatorBean getCreator() {
            return creator;
        }

        public void setCreator(CreatorBean creator) {
            this.creator = creator;
        }

        public boolean isSubscribed() {
            return subscribed;
        }

        public void setSubscribed(boolean subscribed) {
            this.subscribed = subscribed;
        }

        public int getTrackCount() {
            return trackCount;
        }

        public void setTrackCount(int trackCount) {
            this.trackCount = trackCount;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public int getPlayCount() {
            return playCount;
        }

        public void setPlayCount(int playCount) {
            this.playCount = playCount;
        }

        public int getBookCount() {
            return bookCount;
        }

        public void setBookCount(int bookCount) {
            this.bookCount = bookCount;
        }

        public boolean isHighQuality() {
            return highQuality;
        }

        public void setHighQuality(boolean highQuality) {
            this.highQuality = highQuality;
        }

        public static class CreatorBean {
            /**
             * nickname : 网易云音乐
             * userId : 1
             * userType : 3
             * authStatus : 1
             */

            private String nickname;
            private int userId;
            private int userType;
            private int authStatus;

            public String getNickname() {
                return nickname;
            }

            public void setNickname(String nickname) {
                this.nickname = nickname;
            }

            public int getUserId() {
                return userId;
            }

            public void setUserId(int userId) {
                this.userId = userId;
            }

            public int getUserType() {
                return userType;
            }

            public void setUserType(int userType) {
                this.userType = userType;
            }

            public int getAuthStatus() {
                return authStatus;
            }

            public void setAuthStatus(int authStatus) {
                this.authStatus = authStatus;
            }
        }
    }

}
