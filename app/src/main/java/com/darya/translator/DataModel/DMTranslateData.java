package com.darya.translator.DataModel;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DMTranslateData {


    /**
     * responseData : {"translatedText":"Please, specify two different languages","match":0.99}
     * quotaFinished : false
     * mtLangSupported : null
     * responseDetails : 
     * responseStatus : 200
     * responderId : 228
     * exception_code : null
     * matches : [{"id":"425364134","segment":"persian","translation":"Please, specify two different languages","source":"en-US","target":"fa-IR","quality":"74","reference":null,"usage-count":1,"subject":"General","created-by":"MateCat","last-updated-by":"","create-date":"2016-05-08 15:27:10","last-update-date":"2016-05-08 15:27:10","match":0.99},{"id":"434620740","segment":"Persian","translation":"فارسی","source":"en-GB","target":"fa-IR","quality":"74","reference":null,"usage-count":1,"subject":"All","created-by":"MateCat","last-updated-by":"MateCat","create-date":"2021-12-19 09:10:07","last-update-date":"2021-12-19 09:10:07","match":0.98},{"id":"434077201","segment":"Persian","translation":"Persian","source":"en-US","target":"fa-IR","quality":"74","reference":null,"usage-count":1,"subject":"All","created-by":"MateCat","last-updated-by":"MateCat","create-date":"2021-08-20 22:22:49","last-update-date":"2021-08-20 22:22:49","match":0.97}]
     */

    @SerializedName("responseData")
    private ResponseDataBean responseData;
    @SerializedName("quotaFinished")
    private boolean quotaFinished;
    @SerializedName("mtLangSupported")
    private Object mtLangSupported;
    @SerializedName("responseDetails")
    private String responseDetails;
    @SerializedName("responseStatus")
    private int responseStatus;
    @SerializedName("responderId")
    private String responderId;
    @SerializedName("exception_code")
    private Object exceptionCode;
    @SerializedName("matches")
    private List<MatchesBean> matches;

    public ResponseDataBean getResponseData() {
        return responseData;
    }

    public void setResponseData(ResponseDataBean responseData) {
        this.responseData = responseData;
    }

    public boolean isQuotaFinished() {
        return quotaFinished;
    }

    public void setQuotaFinished(boolean quotaFinished) {
        this.quotaFinished = quotaFinished;
    }

    public Object getMtLangSupported() {
        return mtLangSupported;
    }

    public void setMtLangSupported(Object mtLangSupported) {
        this.mtLangSupported = mtLangSupported;
    }

    public String getResponseDetails() {
        return responseDetails;
    }

    public void setResponseDetails(String responseDetails) {
        this.responseDetails = responseDetails;
    }

    public int getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(int responseStatus) {
        this.responseStatus = responseStatus;
    }

    public String getResponderId() {
        return responderId;
    }

    public void setResponderId(String responderId) {
        this.responderId = responderId;
    }

    public Object getExceptionCode() {
        return exceptionCode;
    }

    public void setExceptionCode(Object exceptionCode) {
        this.exceptionCode = exceptionCode;
    }

    public List<MatchesBean> getMatches() {
        return matches;
    }

    public void setMatches(List<MatchesBean> matches) {
        this.matches = matches;
    }

    public static class ResponseDataBean  {
        /**
         * translatedText : Please, specify two different languages
         * match : 0.99
         */

        @SerializedName("translatedText")
        private String translatedText;
        @SerializedName("match")
        private double match;

        public String getTranslatedText() {
            return translatedText;
        }

        public void setTranslatedText(String translatedText) {
            this.translatedText = translatedText;
        }

        public double getMatch() {
            return match;
        }

        public void setMatch(double match) {
            this.match = match;
        }
    }

    public static class MatchesBean  {
        /**
         * id : 425364134
         * segment : persian
         * translation : Please, specify two different languages
         * source : en-US
         * target : fa-IR
         * quality : 74
         * reference : null
         * usage-count : 1
         * subject : General
         * created-by : MateCat
         * last-updated-by : 
         * create-date : 2016-05-08 15:27:10
         * last-update-date : 2016-05-08 15:27:10
         * match : 0.99
         */

        @SerializedName("id")
        private String id;
        @SerializedName("segment")
        private String segment;
        @SerializedName("translation")
        private String translation;
        @SerializedName("source")
        private String source;
        @SerializedName("target")
        private String target;
        @SerializedName("quality")
        private String quality;
        @SerializedName("reference")
        private Object reference;
        @SerializedName("usage-count")
        private int usagecount;
        @SerializedName("subject")
        private String subject;
        @SerializedName("created-by")
        private String createdby;
        @SerializedName("last-updated-by")
        private String lastupdatedby;
        @SerializedName("create-date")
        private String createdate;
        @SerializedName("last-update-date")
        private String lastupdatedate;
        @SerializedName("match")
        private double match;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getSegment() {
            return segment;
        }

        public void setSegment(String segment) {
            this.segment = segment;
        }

        public String getTranslation() {
            return translation;
        }

        public void setTranslation(String translation) {
            this.translation = translation;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getTarget() {
            return target;
        }

        public void setTarget(String target) {
            this.target = target;
        }

        public String getQuality() {
            return quality;
        }

        public void setQuality(String quality) {
            this.quality = quality;
        }

        public Object getReference() {
            return reference;
        }

        public void setReference(Object reference) {
            this.reference = reference;
        }

        public int getUsagecount() {
            return usagecount;
        }

        public void setUsagecount(int usagecount) {
            this.usagecount = usagecount;
        }

        public String getSubject() {
            return subject;
        }

        public void setSubject(String subject) {
            this.subject = subject;
        }

        public String getCreatedby() {
            return createdby;
        }

        public void setCreatedby(String createdby) {
            this.createdby = createdby;
        }

        public String getLastupdatedby() {
            return lastupdatedby;
        }

        public void setLastupdatedby(String lastupdatedby) {
            this.lastupdatedby = lastupdatedby;
        }

        public String getCreatedate() {
            return createdate;
        }

        public void setCreatedate(String createdate) {
            this.createdate = createdate;
        }

        public String getLastupdatedate() {
            return lastupdatedate;
        }

        public void setLastupdatedate(String lastupdatedate) {
            this.lastupdatedate = lastupdatedate;
        }

        public double getMatch() {
            return match;
        }

        public void setMatch(double match) {
            this.match = match;
        }
    }
}
