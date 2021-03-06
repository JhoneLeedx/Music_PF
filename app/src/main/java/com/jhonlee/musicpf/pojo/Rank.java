package com.jhonlee.musicpf.pojo;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by JhoneLee on 2017/3/23.
 */

public class Rank {


    /**
     * songs : [{"id":29019227,"name":"Sugar","artists":[{"id":96266,"name":"Maroon 5","picUrl":null,"alias":[],"albumSize":0,"picId":0,"img1v1Url":"http://p3.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1":0,"trans":null}],"album":{"id":2980029,"name":"V","artist":{"id":0,"name":"","picUrl":null,"alias":[],"albumSize":0,"picId":0,"img1v1Url":"http://p4.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1":0,"trans":null},"publishTime":1409587200007,"size":14,"copyrightId":7003,"status":0,"picId":6655343883051583},"duration":235493,"copyrightId":7003,"status":0,"alias":[],"rtype":0,"ftype":0,"mvid":378783,"fee":0,"rUrl":null}]
     * songCount : 326
     */

    private int songCount;
    private List<SongsBean> songs;

    public int getSongCount() {
        return songCount;
    }

    public void setSongCount(int songCount) {
        this.songCount = songCount;
    }

    public List<SongsBean> getSongs() {
        return songs;
    }

    public void setSongs(List<SongsBean> songs) {
        this.songs = songs;
    }

    public static class SongsBean implements Parcelable{
        /**
         * id : 29019227
         * name : Sugar
         * artists : [{"id":96266,"name":"Maroon 5","picUrl":null,"alias":[],"albumSize":0,"picId":0,"img1v1Url":"http://p3.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1":0,"trans":null}]
         * album : {"id":2980029,"name":"V","artist":{"id":0,"name":"","picUrl":null,"alias":[],"albumSize":0,"picId":0,"img1v1Url":"http://p4.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1":0,"trans":null},"publishTime":1409587200007,"size":14,"copyrightId":7003,"status":0,"picId":6655343883051583}
         * duration : 235493
         * copyrightId : 7003
         * status : 0
         * alias : []
         * rtype : 0
         * ftype : 0
         * mvid : 378783
         * fee : 0
         * rUrl : null
         */
        private int id;
        private String name;
        private AlbumBean album;
        private int duration;
        private int copyrightId;
        private int status;
        private int rtype;
        private int ftype;
        private int mvid;
        private int fee;
        private Object rUrl;
        private List<ArtistsBean> artists;
        private List<?> alias;

        protected SongsBean(Parcel in) {
            id = in.readInt();
            name = in.readString();
            duration = in.readInt();
            copyrightId = in.readInt();
            status = in.readInt();
            rtype = in.readInt();
            ftype = in.readInt();
            mvid = in.readInt();
            fee = in.readInt();
        }

        public static final Creator<SongsBean> CREATOR = new Creator<SongsBean>() {
            @Override
            public SongsBean createFromParcel(Parcel in) {
                return new SongsBean(in);
            }

            @Override
            public SongsBean[] newArray(int size) {
                return new SongsBean[size];
            }
        };

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

        public AlbumBean getAlbum() {
            return album;
        }

        public void setAlbum(AlbumBean album) {
            this.album = album;
        }

        public int getDuration() {
            return duration;
        }

        public void setDuration(int duration) {
            this.duration = duration;
        }

        public int getCopyrightId() {
            return copyrightId;
        }

        public void setCopyrightId(int copyrightId) {
            this.copyrightId = copyrightId;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public int getRtype() {
            return rtype;
        }

        public void setRtype(int rtype) {
            this.rtype = rtype;
        }

        public int getFtype() {
            return ftype;
        }

        public void setFtype(int ftype) {
            this.ftype = ftype;
        }

        public int getMvid() {
            return mvid;
        }

        public void setMvid(int mvid) {
            this.mvid = mvid;
        }

        public int getFee() {
            return fee;
        }

        public void setFee(int fee) {
            this.fee = fee;
        }

        public Object getRUrl() {
            return rUrl;
        }

        public void setRUrl(Object rUrl) {
            this.rUrl = rUrl;
        }

        public List<ArtistsBean> getArtists() {
            return artists;
        }

        public void setArtists(List<ArtistsBean> artists) {
            this.artists = artists;
        }

        public List<?> getAlias() {
            return alias;
        }

        public void setAlias(List<?> alias) {
            this.alias = alias;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(id);
            dest.writeString(name);
            dest.writeInt(duration);
            dest.writeInt(copyrightId);
            dest.writeInt(status);
            dest.writeInt(rtype);
            dest.writeInt(ftype);
            dest.writeInt(mvid);
            dest.writeInt(fee);
        }

        public static class AlbumBean {
            /**
             * id : 2980029
             * name : V
             * artist : {"id":0,"name":"","picUrl":null,"alias":[],"albumSize":0,"picId":0,"img1v1Url":"http://p4.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1":0,"trans":null}
             * publishTime : 1409587200007
             * size : 14
             * copyrightId : 7003
             * status : 0
             * picId : 6655343883051583
             */
            private int id;
            private String name;
            private ArtistBean artist;
            private long publishTime;
            private int size;
            private int copyrightId;
            private int status;
            private long picId;

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

            public ArtistBean getArtist() {
                return artist;
            }

            public void setArtist(ArtistBean artist) {
                this.artist = artist;
            }

            public long getPublishTime() {
                return publishTime;
            }

            public void setPublishTime(long publishTime) {
                this.publishTime = publishTime;
            }

            public int getSize() {
                return size;
            }

            public void setSize(int size) {
                this.size = size;
            }

            public int getCopyrightId() {
                return copyrightId;
            }

            public void setCopyrightId(int copyrightId) {
                this.copyrightId = copyrightId;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public long getPicId() {
                return picId;
            }

            public void setPicId(long picId) {
                this.picId = picId;
            }

            public static class ArtistBean {
                /**
                 * id : 0
                 * name :
                 * picUrl : null
                 * alias : []
                 * albumSize : 0
                 * picId : 0
                 * img1v1Url : http://p4.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg
                 * img1v1 : 0
                 * trans : null
                 */

                private int id;
                private String name;
                private Object picUrl;
                private int albumSize;
                private int picId;
                private String img1v1Url;
                private int img1v1;
                private Object trans;
                private List<?> alias;

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

                public Object getPicUrl() {
                    return picUrl;
                }

                public void setPicUrl(Object picUrl) {
                    this.picUrl = picUrl;
                }

                public int getAlbumSize() {
                    return albumSize;
                }

                public void setAlbumSize(int albumSize) {
                    this.albumSize = albumSize;
                }

                public int getPicId() {
                    return picId;
                }

                public void setPicId(int picId) {
                    this.picId = picId;
                }

                public String getImg1v1Url() {
                    return img1v1Url;
                }

                public void setImg1v1Url(String img1v1Url) {
                    this.img1v1Url = img1v1Url;
                }

                public int getImg1v1() {
                    return img1v1;
                }

                public void setImg1v1(int img1v1) {
                    this.img1v1 = img1v1;
                }

                public Object getTrans() {
                    return trans;
                }

                public void setTrans(Object trans) {
                    this.trans = trans;
                }

                public List<?> getAlias() {
                    return alias;
                }

                public void setAlias(List<?> alias) {
                    this.alias = alias;
                }
            }
        }

        public static class ArtistsBean {
            /**
             * id : 96266
             * name : Maroon 5
             * picUrl : null
             * alias : []
             * albumSize : 0
             * picId : 0
             * img1v1Url : http://p3.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg
             * img1v1 : 0
             * trans : null
             */

            private int id;
            private String name;
            private Object picUrl;
            private int albumSize;
            private int picId;
            private String img1v1Url;
            private int img1v1;
            private Object trans;
            private List<?> alias;

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

            public Object getPicUrl() {
                return picUrl;
            }

            public void setPicUrl(Object picUrl) {
                this.picUrl = picUrl;
            }

            public int getAlbumSize() {
                return albumSize;
            }

            public void setAlbumSize(int albumSize) {
                this.albumSize = albumSize;
            }

            public int getPicId() {
                return picId;
            }

            public void setPicId(int picId) {
                this.picId = picId;
            }

            public String getImg1v1Url() {
                return img1v1Url;
            }

            public void setImg1v1Url(String img1v1Url) {
                this.img1v1Url = img1v1Url;
            }

            public int getImg1v1() {
                return img1v1;
            }

            public void setImg1v1(int img1v1) {
                this.img1v1 = img1v1;
            }

            public Object getTrans() {
                return trans;
            }

            public void setTrans(Object trans) {
                this.trans = trans;
            }

            public List<?> getAlias() {
                return alias;
            }

            public void setAlias(List<?> alias) {
                this.alias = alias;
            }
        }
    }

}
