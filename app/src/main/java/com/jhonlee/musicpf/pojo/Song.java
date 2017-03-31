package com.jhonlee.musicpf.pojo;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by JhoneLee on 2017/3/22.
 */

public class Song {

        /**
         * subscribers : []
         * subscribed : false
         * specialType : 10
         * anonimous : false
         * trackUpdateTime : 1490002227416
         * highQuality : false
         * trackCount : 14
         * coverImgId : 19140298416347251
         * totalDuration : 2690
         * playCount : 16934358
         * adType : 0
         * createTime : 1381223783756
         * trackNumberUpdateTime : 1490002227353
         * userId : 577015
         * coverImgUrl : http://p1.music.126.net/N2whh2Prf0l8QHmCpShrcQ==/19140298416347251.jpg
         * privacy : 0
         * newImported : false
         * updateTime : 1490002227406
         * commentThreadId : A_PL_0_4395559
         * subscribedCount : 72060
         * cloudTrackCount : 0
         * description : 华语金曲榜
         * ordered : true
         * tags : ["榜单"]
         * status : 0
         * name : 华语金曲榜
         * id : 4395559
         * shareCount : 167
         * coverImgId_str : 19140298416347251
         * commentCount : 777
         */

        private boolean subscribed;
        private CreatorBean creator;
        private Object artists;
        private int specialType;
        private boolean anonimous;
        private long trackUpdateTime;
        private boolean highQuality;
        private int trackCount;
        private long coverImgId;
        private int totalDuration;
        private int playCount;
        private int adType;
        private long createTime;
        private long trackNumberUpdateTime;
        private int userId;
        private String coverImgUrl;
        private int privacy;
        private boolean newImported;
        private long updateTime;
        private String commentThreadId;
        private int subscribedCount;
        private int cloudTrackCount;
        private String description;
        private boolean ordered;
        private int status;
        private String name;
        private int id;
        private int shareCount;
        private String coverImgId_str;
        private int commentCount;
        private List<?> subscribers;
        private List<TracksBean> tracks;
        private List<String> tags;

        public boolean isSubscribed() {
            return subscribed;
        }

        public void setSubscribed(boolean subscribed) {
            this.subscribed = subscribed;
        }

        public CreatorBean getCreator() {
            return creator;
        }

        public void setCreator(CreatorBean creator) {
            this.creator = creator;
        }

        public Object getArtists() {
            return artists;
        }

        public void setArtists(Object artists) {
            this.artists = artists;
        }

        public int getSpecialType() {
            return specialType;
        }

        public void setSpecialType(int specialType) {
            this.specialType = specialType;
        }

        public boolean isAnonimous() {
            return anonimous;
        }

        public void setAnonimous(boolean anonimous) {
            this.anonimous = anonimous;
        }

        public long getTrackUpdateTime() {
            return trackUpdateTime;
        }

        public void setTrackUpdateTime(long trackUpdateTime) {
            this.trackUpdateTime = trackUpdateTime;
        }

        public boolean isHighQuality() {
            return highQuality;
        }

        public void setHighQuality(boolean highQuality) {
            this.highQuality = highQuality;
        }

        public int getTrackCount() {
            return trackCount;
        }

        public void setTrackCount(int trackCount) {
            this.trackCount = trackCount;
        }

        public long getCoverImgId() {
            return coverImgId;
        }

        public void setCoverImgId(long coverImgId) {
            this.coverImgId = coverImgId;
        }

        public int getTotalDuration() {
            return totalDuration;
        }

        public void setTotalDuration(int totalDuration) {
            this.totalDuration = totalDuration;
        }

        public int getPlayCount() {
            return playCount;
        }

        public void setPlayCount(int playCount) {
            this.playCount = playCount;
        }

        public int getAdType() {
            return adType;
        }

        public void setAdType(int adType) {
            this.adType = adType;
        }

        public long getCreateTime() {
            return createTime;
        }

        public void setCreateTime(long createTime) {
            this.createTime = createTime;
        }

        public long getTrackNumberUpdateTime() {
            return trackNumberUpdateTime;
        }

        public void setTrackNumberUpdateTime(long trackNumberUpdateTime) {
            this.trackNumberUpdateTime = trackNumberUpdateTime;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public String getCoverImgUrl() {
            return coverImgUrl;
        }

        public void setCoverImgUrl(String coverImgUrl) {
            this.coverImgUrl = coverImgUrl;
        }

        public int getPrivacy() {
            return privacy;
        }

        public void setPrivacy(int privacy) {
            this.privacy = privacy;
        }

        public boolean isNewImported() {
            return newImported;
        }

        public void setNewImported(boolean newImported) {
            this.newImported = newImported;
        }

        public long getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(long updateTime) {
            this.updateTime = updateTime;
        }

        public String getCommentThreadId() {
            return commentThreadId;
        }

        public void setCommentThreadId(String commentThreadId) {
            this.commentThreadId = commentThreadId;
        }

        public int getSubscribedCount() {
            return subscribedCount;
        }

        public void setSubscribedCount(int subscribedCount) {
            this.subscribedCount = subscribedCount;
        }

        public int getCloudTrackCount() {
            return cloudTrackCount;
        }

        public void setCloudTrackCount(int cloudTrackCount) {
            this.cloudTrackCount = cloudTrackCount;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public boolean isOrdered() {
            return ordered;
        }

        public void setOrdered(boolean ordered) {
            this.ordered = ordered;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getShareCount() {
            return shareCount;
        }

        public void setShareCount(int shareCount) {
            this.shareCount = shareCount;
        }

        public String getCoverImgId_str() {
            return coverImgId_str;
        }

        public void setCoverImgId_str(String coverImgId_str) {
            this.coverImgId_str = coverImgId_str;
        }

        public int getCommentCount() {
            return commentCount;
        }

        public void setCommentCount(int commentCount) {
            this.commentCount = commentCount;
        }

        public List<?> getSubscribers() {
            return subscribers;
        }

        public void setSubscribers(List<?> subscribers) {
            this.subscribers = subscribers;
        }

        public List<TracksBean> getTracks() {
            return tracks;
        }

        public void setTracks(List<TracksBean> tracks) {
            this.tracks = tracks;
        }

        public List<String> getTags() {
            return tags;
        }

        public void setTags(List<String> tags) {
            this.tags = tags;
        }

        public static class CreatorBean {
            /**
             * defaultAvatar : false
             * province : 440000
             * authStatus : 1
             * followed : false
             * avatarUrl : http://p1.music.126.net/N2whh2Prf0l8QHmCpShrcQ==/19140298416347251.jpg
             * accountStatus : 0
             * gender : 1
             * city : 440100
             * birthday : 1199116800000
             * userId : 577015
             * userType : 1
             * nickname : 华语金曲榜
             * signature :
             * description : 华语金曲榜官方账号
             * detailDescription : 华语金曲榜官方账号
             * avatarImgId : 19140298416347251
             * backgroundImgId : 3188583720587810
             * backgroundUrl : http://p1.music.126.net/M3Zul-R_7FF2Tr-uQrY-Iw==/3188583720587810.jpg
             * authority : 3
             * mutual : false
             * expertTags : null
             * djStatus : 10
             * vipType : 0
             * remarkName : null
             * backgroundImgIdStr : 3188583720587810
             * avatarImgIdStr : 19140298416347251
             * avatarImgId_str : 19140298416347251
             */

            private boolean defaultAvatar;
            private int province;
            private int authStatus;
            private boolean followed;
            private String avatarUrl;
            private int accountStatus;
            private int gender;
            private int city;
            private long birthday;
            private int userId;
            private int userType;
            private String nickname;
            private String signature;
            private String description;
            private String detailDescription;
            private long avatarImgId;
            private long backgroundImgId;
            private String backgroundUrl;
            private int authority;
            private boolean mutual;
            private Object expertTags;
            private int djStatus;
            private int vipType;
            private Object remarkName;
            private String backgroundImgIdStr;
            private String avatarImgIdStr;
            private String avatarImgId_str;

            public boolean isDefaultAvatar() {
                return defaultAvatar;
            }

            public void setDefaultAvatar(boolean defaultAvatar) {
                this.defaultAvatar = defaultAvatar;
            }

            public int getProvince() {
                return province;
            }

            public void setProvince(int province) {
                this.province = province;
            }

            public int getAuthStatus() {
                return authStatus;
            }

            public void setAuthStatus(int authStatus) {
                this.authStatus = authStatus;
            }

            public boolean isFollowed() {
                return followed;
            }

            public void setFollowed(boolean followed) {
                this.followed = followed;
            }

            public String getAvatarUrl() {
                return avatarUrl;
            }

            public void setAvatarUrl(String avatarUrl) {
                this.avatarUrl = avatarUrl;
            }

            public int getAccountStatus() {
                return accountStatus;
            }

            public void setAccountStatus(int accountStatus) {
                this.accountStatus = accountStatus;
            }

            public int getGender() {
                return gender;
            }

            public void setGender(int gender) {
                this.gender = gender;
            }

            public int getCity() {
                return city;
            }

            public void setCity(int city) {
                this.city = city;
            }

            public long getBirthday() {
                return birthday;
            }

            public void setBirthday(long birthday) {
                this.birthday = birthday;
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

            public String getNickname() {
                return nickname;
            }

            public void setNickname(String nickname) {
                this.nickname = nickname;
            }

            public String getSignature() {
                return signature;
            }

            public void setSignature(String signature) {
                this.signature = signature;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getDetailDescription() {
                return detailDescription;
            }

            public void setDetailDescription(String detailDescription) {
                this.detailDescription = detailDescription;
            }

            public long getAvatarImgId() {
                return avatarImgId;
            }

            public void setAvatarImgId(long avatarImgId) {
                this.avatarImgId = avatarImgId;
            }

            public long getBackgroundImgId() {
                return backgroundImgId;
            }

            public void setBackgroundImgId(long backgroundImgId) {
                this.backgroundImgId = backgroundImgId;
            }

            public String getBackgroundUrl() {
                return backgroundUrl;
            }

            public void setBackgroundUrl(String backgroundUrl) {
                this.backgroundUrl = backgroundUrl;
            }

            public int getAuthority() {
                return authority;
            }

            public void setAuthority(int authority) {
                this.authority = authority;
            }

            public boolean isMutual() {
                return mutual;
            }

            public void setMutual(boolean mutual) {
                this.mutual = mutual;
            }

            public Object getExpertTags() {
                return expertTags;
            }

            public void setExpertTags(Object expertTags) {
                this.expertTags = expertTags;
            }

            public int getDjStatus() {
                return djStatus;
            }

            public void setDjStatus(int djStatus) {
                this.djStatus = djStatus;
            }

            public int getVipType() {
                return vipType;
            }

            public void setVipType(int vipType) {
                this.vipType = vipType;
            }

            public Object getRemarkName() {
                return remarkName;
            }

            public void setRemarkName(Object remarkName) {
                this.remarkName = remarkName;
            }

            public String getBackgroundImgIdStr() {
                return backgroundImgIdStr;
            }

            public void setBackgroundImgIdStr(String backgroundImgIdStr) {
                this.backgroundImgIdStr = backgroundImgIdStr;
            }

            public String getAvatarImgIdStr() {
                return avatarImgIdStr;
            }

            public void setAvatarImgIdStr(String avatarImgIdStr) {
                this.avatarImgIdStr = avatarImgIdStr;
            }

            public String getAvatarImgId_str() {
                return avatarImgId_str;
            }

            public void setAvatarImgId_str(String avatarImgId_str) {
                this.avatarImgId_str = avatarImgId_str;
            }
        }

        public static class TracksBean implements Parcelable{
            /**
             * name : 愿望树
             * id : 451991417
             * position : 1
             * alias : []
             * status : 0
             * fee : 0
             * copyrightId : 29010
             * disc :
             * no : 0
             * artists : [{"name":"胡琳","id":12262203,"picId":0,"img1v1Id":0,"briefDesc":"","picUrl":"http://p4.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1Url":"http://p3.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","albumSize":0,"alias":[],"trans":"","musicSize":0}]
             * album : {"name":"愿望树","id":35113513,"type":"EP/Single","size":1,"picId":18829136627356227,"blurPicUrl":"http://p3.music.126.net/N99I1stbig4wdAea1eAqIg==/18829136627356227.jpg","companyId":0,"pic":18829136627356227,"picUrl":"http://p4.music.126.net/N99I1stbig4wdAea1eAqIg==/18829136627356227.jpg","publishTime":1483632000007,"description":"","tags":"","company":"维音唱片","briefDesc":"","artist":{"name":"","id":0,"picId":0,"img1v1Id":0,"briefDesc":"","picUrl":"http://p4.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1Url":"http://p3.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","albumSize":0,"alias":[],"trans":"","musicSize":0},"songs":[],"alias":[],"status":0,"copyrightId":29010,"commentThreadId":"R_AL_3_35113513","artists":[{"name":"胡琳","id":12262203,"picId":0,"img1v1Id":0,"briefDesc":"","picUrl":"http://p3.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1Url":"http://p4.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","albumSize":0,"alias":[],"trans":"","musicSize":0}],"picId_str":"18829136627356227"}
             * starred : false
             * popularity : 100
             * score : 100
             * starredNum : 0
             * duration : 210108
             * playedNum : 0
             * dayPlays : 0
             * hearTime : 0
             * ringtone : null
             * crbt : null
             * audition : null
             * copyFrom :
             * commentThreadId : R_SO_4_451991417
             * rtUrl : null
             * ftype : 0
             * rtUrls : []
             * hMusic : {"name":null,"id":1268896386,"size":8413562,"extension":"mp3","sr":44100,"dfsId":18566353348327704,"bitrate":320000,"playTime":210108,"volumeDelta":0.161603,"dfsId_str":"18566353348327704"}
             * mMusic : {"name":null,"id":1268896387,"size":4206804,"extension":"mp3","sr":44100,"dfsId":18517974836705411,"bitrate":160000,"playTime":210108,"volumeDelta":0.427591,"dfsId_str":"18517974836705411"}
             * lMusic : {"name":null,"id":1268896388,"size":2524100,"extension":"mp3","sr":44100,"dfsId":18753270325046280,"bitrate":96000,"playTime":210108,"volumeDelta":0.0135296,"dfsId_str":"18753270325046280"}
             * bMusic : {"name":null,"id":1268896388,"size":2524100,"extension":"mp3","sr":44100,"dfsId":18753270325046280,"bitrate":96000,"playTime":210108,"volumeDelta":0.0135296,"dfsId_str":"18753270325046280"}
             * rtype : 0
             * rurl : null
             * mp3Url : http://m2.music.126.net/M_9mKmWs3_biX5SjV230OA==/18753270325046280.mp3
             * mvid : 0
             * lastRank : 1
             */

            private String name;
            private int id;
            private int position;
            private int status;
            private int fee;
            private int copyrightId;
            private String disc;
            private int no;
            private AlbumBean album;
            private boolean starred;
            private int popularity;
            private int score;
            private int starredNum;
            private int duration;
            private int playedNum;
            private int dayPlays;
            private int hearTime;
            private Object ringtone;
            private Object crbt;
            private Object audition;
            private String copyFrom;
            private String commentThreadId;
            private Object rtUrl;
            private int ftype;
            private HMusicBean hMusic;
            private MMusicBean mMusic;
            private LMusicBean lMusic;
            private BMusicBean bMusic;
            private int rtype;
            private Object rurl;
            private String mp3Url;
            private int mvid;
            private int lastRank;
            private List<?> alias;
            private List<ArtistsBeanX> artists;
            private List<?> rtUrls;

            protected TracksBean(Parcel in) {
                name = in.readString();
                id = in.readInt();
                position = in.readInt();
                status = in.readInt();
                fee = in.readInt();
                copyrightId = in.readInt();
                disc = in.readString();
                no = in.readInt();
                starred = in.readByte() != 0;
                popularity = in.readInt();
                score = in.readInt();
                starredNum = in.readInt();
                duration = in.readInt();
                playedNum = in.readInt();
                dayPlays = in.readInt();
                hearTime = in.readInt();
                copyFrom = in.readString();
                commentThreadId = in.readString();
                ftype = in.readInt();
                rtype = in.readInt();
                mp3Url = in.readString();
                mvid = in.readInt();
                lastRank = in.readInt();
            }

            public static final Creator<TracksBean> CREATOR = new Creator<TracksBean>() {
                @Override
                public TracksBean createFromParcel(Parcel in) {
                    return new TracksBean(in);
                }

                @Override
                public TracksBean[] newArray(int size) {
                    return new TracksBean[size];
                }
            };

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getPosition() {
                return position;
            }

            public void setPosition(int position) {
                this.position = position;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public int getFee() {
                return fee;
            }

            public void setFee(int fee) {
                this.fee = fee;
            }

            public int getCopyrightId() {
                return copyrightId;
            }

            public void setCopyrightId(int copyrightId) {
                this.copyrightId = copyrightId;
            }

            public String getDisc() {
                return disc;
            }

            public void setDisc(String disc) {
                this.disc = disc;
            }

            public int getNo() {
                return no;
            }

            public void setNo(int no) {
                this.no = no;
            }

            public AlbumBean getAlbum() {
                return album;
            }

            public void setAlbum(AlbumBean album) {
                this.album = album;
            }

            public boolean isStarred() {
                return starred;
            }

            public void setStarred(boolean starred) {
                this.starred = starred;
            }

            public int getPopularity() {
                return popularity;
            }

            public void setPopularity(int popularity) {
                this.popularity = popularity;
            }

            public int getScore() {
                return score;
            }

            public void setScore(int score) {
                this.score = score;
            }

            public int getStarredNum() {
                return starredNum;
            }

            public void setStarredNum(int starredNum) {
                this.starredNum = starredNum;
            }

            public int getDuration() {
                return duration;
            }

            public void setDuration(int duration) {
                this.duration = duration;
            }

            public int getPlayedNum() {
                return playedNum;
            }

            public void setPlayedNum(int playedNum) {
                this.playedNum = playedNum;
            }

            public int getDayPlays() {
                return dayPlays;
            }

            public void setDayPlays(int dayPlays) {
                this.dayPlays = dayPlays;
            }

            public int getHearTime() {
                return hearTime;
            }

            public void setHearTime(int hearTime) {
                this.hearTime = hearTime;
            }

            public Object getRingtone() {
                return ringtone;
            }

            public void setRingtone(Object ringtone) {
                this.ringtone = ringtone;
            }

            public Object getCrbt() {
                return crbt;
            }

            public void setCrbt(Object crbt) {
                this.crbt = crbt;
            }

            public Object getAudition() {
                return audition;
            }

            public void setAudition(Object audition) {
                this.audition = audition;
            }

            public String getCopyFrom() {
                return copyFrom;
            }

            public void setCopyFrom(String copyFrom) {
                this.copyFrom = copyFrom;
            }

            public String getCommentThreadId() {
                return commentThreadId;
            }

            public void setCommentThreadId(String commentThreadId) {
                this.commentThreadId = commentThreadId;
            }

            public Object getRtUrl() {
                return rtUrl;
            }

            public void setRtUrl(Object rtUrl) {
                this.rtUrl = rtUrl;
            }

            public int getFtype() {
                return ftype;
            }

            public void setFtype(int ftype) {
                this.ftype = ftype;
            }

            public HMusicBean getHMusic() {
                return hMusic;
            }

            public void setHMusic(HMusicBean hMusic) {
                this.hMusic = hMusic;
            }

            public MMusicBean getMMusic() {
                return mMusic;
            }

            public void setMMusic(MMusicBean mMusic) {
                this.mMusic = mMusic;
            }

            public LMusicBean getLMusic() {
                return lMusic;
            }

            public void setLMusic(LMusicBean lMusic) {
                this.lMusic = lMusic;
            }

            public BMusicBean getBMusic() {
                return bMusic;
            }

            public void setBMusic(BMusicBean bMusic) {
                this.bMusic = bMusic;
            }

            public int getRtype() {
                return rtype;
            }

            public void setRtype(int rtype) {
                this.rtype = rtype;
            }

            public Object getRurl() {
                return rurl;
            }

            public void setRurl(Object rurl) {
                this.rurl = rurl;
            }

            public String getMp3Url() {
                return mp3Url;
            }

            public void setMp3Url(String mp3Url) {
                this.mp3Url = mp3Url;
            }

            public int getMvid() {
                return mvid;
            }

            public void setMvid(int mvid) {
                this.mvid = mvid;
            }

            public int getLastRank() {
                return lastRank;
            }

            public void setLastRank(int lastRank) {
                this.lastRank = lastRank;
            }

            public List<?> getAlias() {
                return alias;
            }

            public void setAlias(List<?> alias) {
                this.alias = alias;
            }

            public List<ArtistsBeanX> getArtists() {
                return artists;
            }

            public void setArtists(List<ArtistsBeanX> artists) {
                this.artists = artists;
            }

            public List<?> getRtUrls() {
                return rtUrls;
            }

            public void setRtUrls(List<?> rtUrls) {
                this.rtUrls = rtUrls;
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString(name);
                dest.writeInt(id);
                dest.writeInt(position);
                dest.writeInt(status);
                dest.writeInt(fee);
                dest.writeInt(copyrightId);
                dest.writeString(disc);
                dest.writeInt(no);
                dest.writeByte((byte) (starred ? 1 : 0));
                dest.writeInt(popularity);
                dest.writeInt(score);
                dest.writeInt(starredNum);
                dest.writeInt(duration);
                dest.writeInt(playedNum);
                dest.writeInt(dayPlays);
                dest.writeInt(hearTime);
                dest.writeString(copyFrom);
                dest.writeString(commentThreadId);
                dest.writeInt(ftype);
                dest.writeInt(rtype);
                dest.writeString(mp3Url);
                dest.writeInt(mvid);
                dest.writeInt(lastRank);
            }

            public static class AlbumBean {
                /**
                 * name : 愿望树
                 * id : 35113513
                 * type : EP/Single
                 * size : 1
                 * picId : 18829136627356227
                 * blurPicUrl : http://p3.music.126.net/N99I1stbig4wdAea1eAqIg==/18829136627356227.jpg
                 * companyId : 0
                 * pic : 18829136627356227
                 * picUrl : http://p4.music.126.net/N99I1stbig4wdAea1eAqIg==/18829136627356227.jpg
                 * publishTime : 1483632000007
                 * description :
                 * tags :
                 * company : 维音唱片
                 * briefDesc :
                 * artist : {"name":"","id":0,"picId":0,"img1v1Id":0,"briefDesc":"","picUrl":"http://p4.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1Url":"http://p3.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","albumSize":0,"alias":[],"trans":"","musicSize":0}
                 * songs : []
                 * alias : []
                 * status : 0
                 * copyrightId : 29010
                 * commentThreadId : R_AL_3_35113513
                 * artists : [{"name":"胡琳","id":12262203,"picId":0,"img1v1Id":0,"briefDesc":"","picUrl":"http://p3.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","img1v1Url":"http://p4.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg","albumSize":0,"alias":[],"trans":"","musicSize":0}]
                 * picId_str : 18829136627356227
                 */

                private String name;
                private int id;
                private String type;
                private int size;
                private long picId;
                private String blurPicUrl;
                private int companyId;
                private long pic;
                private String picUrl;
                private long publishTime;
                private String description;
                private String tags;
                private String company;
                private String briefDesc;
                private ArtistBean artist;
                private int status;
                private int copyrightId;
                private String commentThreadId;
                private String picId_str;
                private List<?> songs;
                private List<?> alias;
                private List<ArtistsBean> artists;

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getType() {
                    return type;
                }

                public void setType(String type) {
                    this.type = type;
                }

                public int getSize() {
                    return size;
                }

                public void setSize(int size) {
                    this.size = size;
                }

                public long getPicId() {
                    return picId;
                }

                public void setPicId(long picId) {
                    this.picId = picId;
                }

                public String getBlurPicUrl() {
                    return blurPicUrl;
                }

                public void setBlurPicUrl(String blurPicUrl) {
                    this.blurPicUrl = blurPicUrl;
                }

                public int getCompanyId() {
                    return companyId;
                }

                public void setCompanyId(int companyId) {
                    this.companyId = companyId;
                }

                public long getPic() {
                    return pic;
                }

                public void setPic(long pic) {
                    this.pic = pic;
                }

                public String getPicUrl() {
                    return picUrl;
                }

                public void setPicUrl(String picUrl) {
                    this.picUrl = picUrl;
                }

                public long getPublishTime() {
                    return publishTime;
                }

                public void setPublishTime(long publishTime) {
                    this.publishTime = publishTime;
                }

                public String getDescription() {
                    return description;
                }

                public void setDescription(String description) {
                    this.description = description;
                }

                public String getTags() {
                    return tags;
                }

                public void setTags(String tags) {
                    this.tags = tags;
                }

                public String getCompany() {
                    return company;
                }

                public void setCompany(String company) {
                    this.company = company;
                }

                public String getBriefDesc() {
                    return briefDesc;
                }

                public void setBriefDesc(String briefDesc) {
                    this.briefDesc = briefDesc;
                }

                public ArtistBean getArtist() {
                    return artist;
                }

                public void setArtist(ArtistBean artist) {
                    this.artist = artist;
                }

                public int getStatus() {
                    return status;
                }

                public void setStatus(int status) {
                    this.status = status;
                }

                public int getCopyrightId() {
                    return copyrightId;
                }

                public void setCopyrightId(int copyrightId) {
                    this.copyrightId = copyrightId;
                }

                public String getCommentThreadId() {
                    return commentThreadId;
                }

                public void setCommentThreadId(String commentThreadId) {
                    this.commentThreadId = commentThreadId;
                }

                public String getPicId_str() {
                    return picId_str;
                }

                public void setPicId_str(String picId_str) {
                    this.picId_str = picId_str;
                }

                public List<?> getSongs() {
                    return songs;
                }

                public void setSongs(List<?> songs) {
                    this.songs = songs;
                }

                public List<?> getAlias() {
                    return alias;
                }

                public void setAlias(List<?> alias) {
                    this.alias = alias;
                }

                public List<ArtistsBean> getArtists() {
                    return artists;
                }

                public void setArtists(List<ArtistsBean> artists) {
                    this.artists = artists;
                }

                public static class ArtistBean {
                    /**
                     * name :
                     * id : 0
                     * picId : 0
                     * img1v1Id : 0
                     * briefDesc :
                     * picUrl : http://p4.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg
                     * img1v1Url : http://p3.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg
                     * albumSize : 0
                     * alias : []
                     * trans :
                     * musicSize : 0
                     */

                    private String name;
                    private int id;
                    private int picId;
                    private int img1v1Id;
                    private String briefDesc;
                    private String picUrl;
                    private String img1v1Url;
                    private int albumSize;
                    private String trans;
                    private int musicSize;
                    private List<?> alias;

                    public String getName() {
                        return name;
                    }

                    public void setName(String name) {
                        this.name = name;
                    }

                    public int getId() {
                        return id;
                    }

                    public void setId(int id) {
                        this.id = id;
                    }

                    public int getPicId() {
                        return picId;
                    }

                    public void setPicId(int picId) {
                        this.picId = picId;
                    }

                    public int getImg1v1Id() {
                        return img1v1Id;
                    }

                    public void setImg1v1Id(int img1v1Id) {
                        this.img1v1Id = img1v1Id;
                    }

                    public String getBriefDesc() {
                        return briefDesc;
                    }

                    public void setBriefDesc(String briefDesc) {
                        this.briefDesc = briefDesc;
                    }

                    public String getPicUrl() {
                        return picUrl;
                    }

                    public void setPicUrl(String picUrl) {
                        this.picUrl = picUrl;
                    }

                    public String getImg1v1Url() {
                        return img1v1Url;
                    }

                    public void setImg1v1Url(String img1v1Url) {
                        this.img1v1Url = img1v1Url;
                    }

                    public int getAlbumSize() {
                        return albumSize;
                    }

                    public void setAlbumSize(int albumSize) {
                        this.albumSize = albumSize;
                    }

                    public String getTrans() {
                        return trans;
                    }

                    public void setTrans(String trans) {
                        this.trans = trans;
                    }

                    public int getMusicSize() {
                        return musicSize;
                    }

                    public void setMusicSize(int musicSize) {
                        this.musicSize = musicSize;
                    }

                    public List<?> getAlias() {
                        return alias;
                    }

                    public void setAlias(List<?> alias) {
                        this.alias = alias;
                    }
                }

                public static class ArtistsBean {
                    /**
                     * name : 胡琳
                     * id : 12262203
                     * picId : 0
                     * img1v1Id : 0
                     * briefDesc :
                     * picUrl : http://p3.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg
                     * img1v1Url : http://p4.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg
                     * albumSize : 0
                     * alias : []
                     * trans :
                     * musicSize : 0
                     */

                    private String name;
                    private int id;
                    private int picId;
                    private int img1v1Id;
                    private String briefDesc;
                    private String picUrl;
                    private String img1v1Url;
                    private int albumSize;
                    private String trans;
                    private int musicSize;
                    private List<?> alias;

                    public String getName() {
                        return name;
                    }

                    public void setName(String name) {
                        this.name = name;
                    }

                    public int getId() {
                        return id;
                    }

                    public void setId(int id) {
                        this.id = id;
                    }

                    public int getPicId() {
                        return picId;
                    }

                    public void setPicId(int picId) {
                        this.picId = picId;
                    }

                    public int getImg1v1Id() {
                        return img1v1Id;
                    }

                    public void setImg1v1Id(int img1v1Id) {
                        this.img1v1Id = img1v1Id;
                    }

                    public String getBriefDesc() {
                        return briefDesc;
                    }

                    public void setBriefDesc(String briefDesc) {
                        this.briefDesc = briefDesc;
                    }

                    public String getPicUrl() {
                        return picUrl;
                    }

                    public void setPicUrl(String picUrl) {
                        this.picUrl = picUrl;
                    }

                    public String getImg1v1Url() {
                        return img1v1Url;
                    }

                    public void setImg1v1Url(String img1v1Url) {
                        this.img1v1Url = img1v1Url;
                    }

                    public int getAlbumSize() {
                        return albumSize;
                    }

                    public void setAlbumSize(int albumSize) {
                        this.albumSize = albumSize;
                    }

                    public String getTrans() {
                        return trans;
                    }

                    public void setTrans(String trans) {
                        this.trans = trans;
                    }

                    public int getMusicSize() {
                        return musicSize;
                    }

                    public void setMusicSize(int musicSize) {
                        this.musicSize = musicSize;
                    }

                    public List<?> getAlias() {
                        return alias;
                    }

                    public void setAlias(List<?> alias) {
                        this.alias = alias;
                    }
                }
            }

            public static class HMusicBean {
                /**
                 * name : null
                 * id : 1268896386
                 * size : 8413562
                 * extension : mp3
                 * sr : 44100
                 * dfsId : 18566353348327704
                 * bitrate : 320000
                 * playTime : 210108
                 * volumeDelta : 0.161603
                 * dfsId_str : 18566353348327704
                 */

                private Object name;
                private int id;
                private int size;
                private String extension;
                private int sr;
                private long dfsId;
                private int bitrate;
                private int playTime;
                private double volumeDelta;
                private String dfsId_str;

                public Object getName() {
                    return name;
                }

                public void setName(Object name) {
                    this.name = name;
                }

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public int getSize() {
                    return size;
                }

                public void setSize(int size) {
                    this.size = size;
                }

                public String getExtension() {
                    return extension;
                }

                public void setExtension(String extension) {
                    this.extension = extension;
                }

                public int getSr() {
                    return sr;
                }

                public void setSr(int sr) {
                    this.sr = sr;
                }

                public long getDfsId() {
                    return dfsId;
                }

                public void setDfsId(long dfsId) {
                    this.dfsId = dfsId;
                }

                public int getBitrate() {
                    return bitrate;
                }

                public void setBitrate(int bitrate) {
                    this.bitrate = bitrate;
                }

                public int getPlayTime() {
                    return playTime;
                }

                public void setPlayTime(int playTime) {
                    this.playTime = playTime;
                }

                public double getVolumeDelta() {
                    return volumeDelta;
                }

                public void setVolumeDelta(double volumeDelta) {
                    this.volumeDelta = volumeDelta;
                }

                public String getDfsId_str() {
                    return dfsId_str;
                }

                public void setDfsId_str(String dfsId_str) {
                    this.dfsId_str = dfsId_str;
                }
            }

            public static class MMusicBean {
                /**
                 * name : null
                 * id : 1268896387
                 * size : 4206804
                 * extension : mp3
                 * sr : 44100
                 * dfsId : 18517974836705411
                 * bitrate : 160000
                 * playTime : 210108
                 * volumeDelta : 0.427591
                 * dfsId_str : 18517974836705411
                 */

                private Object name;
                private int id;
                private int size;
                private String extension;
                private int sr;
                private long dfsId;
                private int bitrate;
                private int playTime;
                private double volumeDelta;
                private String dfsId_str;

                public Object getName() {
                    return name;
                }

                public void setName(Object name) {
                    this.name = name;
                }

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public int getSize() {
                    return size;
                }

                public void setSize(int size) {
                    this.size = size;
                }

                public String getExtension() {
                    return extension;
                }

                public void setExtension(String extension) {
                    this.extension = extension;
                }

                public int getSr() {
                    return sr;
                }

                public void setSr(int sr) {
                    this.sr = sr;
                }

                public long getDfsId() {
                    return dfsId;
                }

                public void setDfsId(long dfsId) {
                    this.dfsId = dfsId;
                }

                public int getBitrate() {
                    return bitrate;
                }

                public void setBitrate(int bitrate) {
                    this.bitrate = bitrate;
                }

                public int getPlayTime() {
                    return playTime;
                }

                public void setPlayTime(int playTime) {
                    this.playTime = playTime;
                }

                public double getVolumeDelta() {
                    return volumeDelta;
                }

                public void setVolumeDelta(double volumeDelta) {
                    this.volumeDelta = volumeDelta;
                }

                public String getDfsId_str() {
                    return dfsId_str;
                }

                public void setDfsId_str(String dfsId_str) {
                    this.dfsId_str = dfsId_str;
                }
            }

            public static class LMusicBean {
                /**
                 * name : null
                 * id : 1268896388
                 * size : 2524100
                 * extension : mp3
                 * sr : 44100
                 * dfsId : 18753270325046280
                 * bitrate : 96000
                 * playTime : 210108
                 * volumeDelta : 0.0135296
                 * dfsId_str : 18753270325046280
                 */

                private Object name;
                private int id;
                private int size;
                private String extension;
                private int sr;
                private long dfsId;
                private int bitrate;
                private int playTime;
                private double volumeDelta;
                private String dfsId_str;

                public Object getName() {
                    return name;
                }

                public void setName(Object name) {
                    this.name = name;
                }

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public int getSize() {
                    return size;
                }

                public void setSize(int size) {
                    this.size = size;
                }

                public String getExtension() {
                    return extension;
                }

                public void setExtension(String extension) {
                    this.extension = extension;
                }

                public int getSr() {
                    return sr;
                }

                public void setSr(int sr) {
                    this.sr = sr;
                }

                public long getDfsId() {
                    return dfsId;
                }

                public void setDfsId(long dfsId) {
                    this.dfsId = dfsId;
                }

                public int getBitrate() {
                    return bitrate;
                }

                public void setBitrate(int bitrate) {
                    this.bitrate = bitrate;
                }

                public int getPlayTime() {
                    return playTime;
                }

                public void setPlayTime(int playTime) {
                    this.playTime = playTime;
                }

                public double getVolumeDelta() {
                    return volumeDelta;
                }

                public void setVolumeDelta(double volumeDelta) {
                    this.volumeDelta = volumeDelta;
                }

                public String getDfsId_str() {
                    return dfsId_str;
                }

                public void setDfsId_str(String dfsId_str) {
                    this.dfsId_str = dfsId_str;
                }
            }

            public static class BMusicBean {
                /**
                 * name : null
                 * id : 1268896388
                 * size : 2524100
                 * extension : mp3
                 * sr : 44100
                 * dfsId : 18753270325046280
                 * bitrate : 96000
                 * playTime : 210108
                 * volumeDelta : 0.0135296
                 * dfsId_str : 18753270325046280
                 */

                private Object name;
                private int id;
                private int size;
                private String extension;
                private int sr;
                private long dfsId;
                private int bitrate;
                private int playTime;
                private double volumeDelta;
                private String dfsId_str;

                public Object getName() {
                    return name;
                }

                public void setName(Object name) {
                    this.name = name;
                }

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public int getSize() {
                    return size;
                }

                public void setSize(int size) {
                    this.size = size;
                }

                public String getExtension() {
                    return extension;
                }

                public void setExtension(String extension) {
                    this.extension = extension;
                }

                public int getSr() {
                    return sr;
                }

                public void setSr(int sr) {
                    this.sr = sr;
                }

                public long getDfsId() {
                    return dfsId;
                }

                public void setDfsId(long dfsId) {
                    this.dfsId = dfsId;
                }

                public int getBitrate() {
                    return bitrate;
                }

                public void setBitrate(int bitrate) {
                    this.bitrate = bitrate;
                }

                public int getPlayTime() {
                    return playTime;
                }

                public void setPlayTime(int playTime) {
                    this.playTime = playTime;
                }

                public double getVolumeDelta() {
                    return volumeDelta;
                }

                public void setVolumeDelta(double volumeDelta) {
                    this.volumeDelta = volumeDelta;
                }

                public String getDfsId_str() {
                    return dfsId_str;
                }

                public void setDfsId_str(String dfsId_str) {
                    this.dfsId_str = dfsId_str;
                }
            }

            public static class ArtistsBeanX {
                /**
                 * name : 胡琳
                 * id : 12262203
                 * picId : 0
                 * img1v1Id : 0
                 * briefDesc :
                 * picUrl : http://p4.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg
                 * img1v1Url : http://p3.music.126.net/6y-UleORITEDbvrOLV0Q8A==/5639395138885805.jpg
                 * albumSize : 0
                 * alias : []
                 * trans :
                 * musicSize : 0
                 */

                private String name;
                private int id;
                private int picId;
                private int img1v1Id;
                private String briefDesc;
                private String picUrl;
                private String img1v1Url;
                private int albumSize;
                private String trans;
                private int musicSize;
                private List<?> alias;

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public int getPicId() {
                    return picId;
                }

                public void setPicId(int picId) {
                    this.picId = picId;
                }

                public int getImg1v1Id() {
                    return img1v1Id;
                }

                public void setImg1v1Id(int img1v1Id) {
                    this.img1v1Id = img1v1Id;
                }

                public String getBriefDesc() {
                    return briefDesc;
                }

                public void setBriefDesc(String briefDesc) {
                    this.briefDesc = briefDesc;
                }

                public String getPicUrl() {
                    return picUrl;
                }

                public void setPicUrl(String picUrl) {
                    this.picUrl = picUrl;
                }

                public String getImg1v1Url() {
                    return img1v1Url;
                }

                public void setImg1v1Url(String img1v1Url) {
                    this.img1v1Url = img1v1Url;
                }

                public int getAlbumSize() {
                    return albumSize;
                }

                public void setAlbumSize(int albumSize) {
                    this.albumSize = albumSize;
                }

                public String getTrans() {
                    return trans;
                }

                public void setTrans(String trans) {
                    this.trans = trans;
                }

                public int getMusicSize() {
                    return musicSize;
                }

                public void setMusicSize(int musicSize) {
                    this.musicSize = musicSize;
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
