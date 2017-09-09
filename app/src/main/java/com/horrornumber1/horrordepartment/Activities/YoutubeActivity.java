package com.horrornumber1.horrordepartment.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
import com.horrornumber1.horrordepartment.CounsilClass.DeveloperKey;
import com.horrornumber1.horrordepartment.Module.ApplicationController;
import com.horrornumber1.horrordepartment.R;

import java.util.ArrayList;

public class YoutubeActivity extends YouTubeBaseActivity implements
        YouTubePlayer.OnInitializedListener{

    private static final int RECOVERY_DIALOG_REQUEST = 1;
    private boolean fullScreen;
    private ImageView youtubeBtn;
    private YouTubePlayer videoPlayer;
    private ArrayList<String> titles;
    private int whichContent=-1;
    private int position=-1;
    private int fromWhere = -1; // 게임=0 라디오=1 흉가=2
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.counsil_youtube);

        mAdView = (AdView) findViewById(R.id.ad_view);

        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mAdView.loadAd(adRequest);

        Tracker t = ((ApplicationController)getApplication()).getTracker(ApplicationController.TrackerName.APP_TRACKER);
        t.setScreenName("Youtube Activity");
        t.send(new HitBuilders.AppViewBuilder().build());


        Intent intent = new Intent(this.getIntent());

        whichContent = intent.getIntExtra("whichContent", -1);
        position= intent.getIntExtra("position", -1);
        fromWhere = intent.getIntExtra("fromWhere", -1);

        titles = new ArrayList<>();

        if(fromWhere==0){
            switch (whichContent){
                case  0:
                    titles.add("-K5TDRE1tts");
                    titles.add("on2kyp_6dUA");
                    titles.add("9ho3cdEowAU");
                    titles.add("i2sJGRMgkQQ");
                    titles.add("k8eAA94eCaY");
                    titles.add("zhnlw8N59IQ");
                    break;

                case 1:
                    titles.add("1C7so1Q0NfU");
                    titles.add("srm8p32_1v4");
                    titles.add("HQG1FBS_dYQ");
                    titles.add("NYUSwutlnXk");
                    titles.add("plbhA3Xjucw");
                    titles.add("-1yBl93pLk");
                    break;
                case 2:
                    titles.add("Oa1NHrTBaCc");
                    break;
                case 3:
                    titles.add("ByJALhmLry4");
                    titles.add("_X-_12109S0");
                    titles.add("3Ge-XLlDdFY");
                    titles.add("R8MYELtptNg");
                    break;
                case 4:
                    titles.add("nimp8IUzOAM");
                    titles.add("vYZ8XUmz-Ho");
                    titles.add("hKl_rgCqt-8");
                    break;
                case 5:
                    titles.add("xVFdQqx5XKs");
                    break;
                case 6:
                    titles.add("BpQHCduMagk");
                    break;


                default:return;
            }
        }else if(fromWhere==1) {
            switch (whichContent) {
                case 0:
                    titles.add("1bMtp1IRLrA");
                    titles.add("6eQ4ie1nbgE");
                    titles.add("S2DOhKlddKY");
                    titles.add("tCnaaSTZ3sM");
                    titles.add("uVw8Y9VIYmk");
                    titles.add("5YBh1b1CK18");
                    titles.add("s1ozHn1dUUg");
                    titles.add("8lmx1yVF01E");
                    titles.add("D8ItA_XxP8E");
                    titles.add("bb3WNoXLNZY");
                    titles.add("0G_IKMUVaZo");
                    titles.add("g8aeQy8vipI");
                    titles.add("HqT2Yt2wiQQ");
                    titles.add("KsPP-EAHBxU");
                    titles.add("OBdtwDf6ZpI");
                    titles.add("-HfkpKF3gDE");
                    titles.add("OXEWXFoC_V0");
                    titles.add("UccTuv_BBvY");
                    titles.add("Hyz7vn-GJbk");
                    titles.add("_tEWiRLCkFM");
                    break;
                case 1:
                    titles.add("vTzQeHIh6LM");
                    titles.add("_O4qhmOOouM");
                    titles.add("_ste_8Su1NQ");
                    titles.add("q_eb2ownZAs");
                    titles.add("cHxFAF_Nnlo");
                    titles.add("ow1DPSMzqmA");
                    titles.add("76vhGFWoaqA");
                    titles.add("py9S_iUr_HI");
                    titles.add("pgvvkRrnLc0");
                    titles.add("3hfS0_kjw84");
                    titles.add("swJzlaS28j8");
                    titles.add("Kuvboz-T7BE");
                    titles.add("HqT2Yt2wiQQ");
                    titles.add("VjShZQGWXh0");
                    titles.add("asrIYbrf5wY");
                    break;
                case 2:
                    titles.add("owhimpvZTkI");
                    titles.add("OSpGh56XWZ8");
                    titles.add("3WVz7bT4b9Y");
                    titles.add("sFEAkdceoYU");
                    titles.add("ytdZATf8-Uw");
                    titles.add("N31zI8S-2wY");
                    titles.add("ZLlwozu4Frw");
                    break;
                case 3:
                    titles.add("zz5mfi-k7dk");
                    titles.add("Rd7LDQLOeXw");
                    titles.add("Dupo7WZxSNE");
                    titles.add("hREtjbE8TTE");
                    titles.add("ZNL3SSmxKrc");
                    titles.add("QxcH44zQyuA");
                    titles.add("ehvhXvg4pSQ");
                    titles.add("rzAZS8B3rXU");
                    titles.add("Qzxh8mqpbOA");
                    titles.add("eR4cxDHk94Y");
                    titles.add("mt1rHQ9rIwY");
                    titles.add("5At6wAIHOMM");
                    titles.add("33wdhpb3x2I");
                    titles.add("rLeYwvXCRkU");
                    titles.add("1N9NnjlF4mE");
                    titles.add("KEZsr27hKxY");
                    titles.add("W-cnUmeb354");
                    titles.add("CX_YUFDSzcM");
                    break;
                case 4:
                    titles.add("9xGJs4BjniQ");
                    titles.add("YWBDg-_H8QA");
                    titles.add("hkzsHPofmVk");
                    titles.add("DItc_UeOHo8");
                    titles.add("pSZtd4y1UXI");
                    titles.add("K6To8jgD9Hs");
                    titles.add("VzW9sCLF6S8");
                    titles.add("fT5sQLRq4wM");
                    titles.add("4X1BkP77Rfg");
                    titles.add("6foc3qEfuEk");
                    titles.add("ijh27azUl9M");
                    titles.add("o_kea_V9y4Y");
                    titles.add("_wIPs3BMaeI");
                    titles.add("fCUPlEegKHI");
                    titles.add("1N9NnjlF4mE");
                    titles.add("KEZsr27hKxY");
                    titles.add("dIkxBvVZdqM");
                    titles.add("2pIv4n4v6Jo");
                    titles.add("5jyR3Ps5olA");
                    titles.add("AGcSsNCgHow");
                    titles.add("-2BRqU5jNkE");
                    titles.add("5RYaGckqiDc");
                    titles.add("3SbWX8LUQo8");
                    titles.add("lQoEXSdeR6Q");
                    titles.add("AVlIaDGQmTU");
                    titles.add("A9uj4gZ6I6I");
                    titles.add("pXoSC6JpE2Q");
                    titles.add("d7EOATrdDgM");
                    titles.add("Cik3DfxAilg");
                    titles.add("v3E7u-oYnTg");
                    titles.add("8VoolhDCNQ0");
                    titles.add("COTt1douhvI");
                    titles.add("ZHjuEi-hJu4");
                    titles.add("KRieR_-hPbc");
                    titles.add("gFwzhD2zoWM");
                    titles.add("PQvHGgpgets");
                    titles.add("zW8032vvv3U");
                    titles.add("554gna-rNqc");
                    titles.add("TWSJpEnI9To");
                    titles.add("4txjFBuJ_Jw");
                    titles.add("DlqVQBQz-w8");
                    titles.add("OfM76C-Ky_c");
                    titles.add("WymWipA-SqI");
                    titles.add("GdSkfH8blek");
                    titles.add("22iJ3Zm9VuQ");
                    titles.add("SSVuqVCo_Z0");
                    titles.add("HLSJ90yu-EY");
                    titles.add("IITYKJXL8zA");
                    titles.add("QJ3PMS836eU");
                    titles.add("_htVO_YzsfY");
                    titles.add("Swj5mx065gU");
                    titles.add("Opzqcr-bYos");
                    titles.add("6433cI9IaJ4");
                    titles.add("dAwxxPIS-zs");
                    titles.add("dyDDFC_eLnM");
                    titles.add("uCZkIF_8RwU");
                    titles.add("2H9wbDGxO9A");
                    titles.add("_smrJuIz8qA");
                    titles.add("UWK4nXg3-GA");
                    titles.add("mGR1BCkgMR4");
                    titles.add("qysa5hBIMKY");
                    titles.add("YZHP2uxAKPQ");
                    titles.add("z6irwmhWsow");
                    titles.add("lm90rFOTN14");
                    titles.add("9Dfeqy6xz20");
                    titles.add("s3t4cA98pzQ");
                    titles.add("NSbn_oRTHtU");
                    titles.add("xJY3VGXQOAI");
                    titles.add("3E4kkXRZFaw");
                    titles.add("UFjwR19Ys5E");
                    titles.add("Nv12mT8eI8o");
                    titles.add("SQqaeeN7ljk");
                    titles.add("PFfiiuUiBGk");
                    titles.add("MeY-cjQ7Qog");
                    titles.add("-cUJpNoPiuA");
                    titles.add("mQmPUTrUhR4");
                    titles.add("OLG6Jv1nExg");
                    titles.add("NtbL3n2vSkY");
                    titles.add("ZuYpxj3gQl8");
                    titles.add("CNi_cKF1ygE");
                    titles.add("5wW7VvRhBic");
                    titles.add("v6tkUsjqlbY");
                    titles.add("NlrxCdNFlto");
                    titles.add("x0TnOxEhw-U");
                    titles.add("3QLZYOn5ndw");

                    break;

                case 5:
                    titles.add("XpGdRVWf4XE");
                    titles.add("h77zCQKjyow");
                    titles.add("EBd8aH0MWXk");
                    titles.add("ekFeiEb4nuA");
                    titles.add("e-SV0VS5uL4");
                    titles.add("t5syQo7hps4");
                    titles.add("972VOr3BAww");
                    titles.add("UO0GgWAJuMQ");
                    titles.add("H6lOsl6YZ6E");
                    titles.add("a4-97fnSGEI");
                    titles.add("SrXPytGTDBA");
                    titles.add("brWd4BVJncw");
                    titles.add("fdibK5U_mQw");
                    titles.add("AobS70Wf_6U");
                    titles.add("Hq5yGmXxCD8");
                    titles.add("5SAKUEHjOc0");
                    titles.add("6cs5LhFYb1g");
                    titles.add("UYpdUrp3V1M");
                    titles.add("4B6TAKKEJqM");
                    titles.add("PCiMjfSuY3Y");
                    titles.add("9xaMOv5Yfjw");
                    titles.add("bp0TSyO_mn0");
                    titles.add("b7C3-K_eTJw");
                    titles.add("ve7amM1qVfw");
                    titles.add("aU-FXAv66dg");
                    titles.add("wFSYjynTDSw");
                    titles.add("746iLd5YvIk");
                    titles.add("DCXkPcNtcQk");
                    titles.add("IYfQxVsiXS0");
                    titles.add("c6DWEt5UbOY");
                    titles.add("WyMdPJezpZ4");
                    titles.add("RfK4tH-mcuk");
                    titles.add("t81slQs4w2A");
                    titles.add("0LuZtMoQMY8");
                    titles.add("YdxR_zwmgHI");
                    titles.add("b2CbD0d7l2A");
                    titles.add("mQk4rfE4_0g");
                    titles.add("_nZ5Vz5oJrE");
                    titles.add("A6HkxuRJWR4");
                    titles.add("H6ycV_Euc7k");
                    titles.add("PAPxuYcdIyU");
                    titles.add("PAB7ND3DuUE");
                    titles.add("2iNeD59feQ8");
                    titles.add("VixqBxxc8vw");
                    titles.add("b-L--rxYHSE");
                    titles.add("_gU5jXAIQMA");
                    titles.add("3bBO1OThul8");
                    titles.add("XNRCMtBteOs");
                    titles.add("ve7amM1qVfw");
                    titles.add("JW3CSSWallA");
                    titles.add("KjP_w1BaXk4");
                    titles.add("G3Ap9lfe-_k");
                    titles.add("W3t81rLnVq8");
                    titles.add("LY6BoY9c-M8");
                    titles.add("aJFGZIyJ_TM");
                    titles.add("lTXUzsCTWeM");
                    titles.add("_oZdOVRG_18");
                    titles.add("5jTB09acZKE");
                    titles.add("4gJgJGb3KBk");
                    titles.add("cidLvh4FhFs");
                    titles.add("DMdIyKJ62CU");
                    titles.add("EyOc4J-eHcc");
                    titles.add("pC8bEMjspeU");
                    titles.add("pEYJHI0am3M");
                    titles.add("SdevyWyc7xY");
                    titles.add("l50ndNex77Q");
                    titles.add("i-KJPFFwxyw");
                    titles.add("-PZMEfe1T-M");
                    titles.add("pcTcMdbPZTM");
                    titles.add("OpPWweO4Cbk");
                    titles.add("qLJIZtqx44g");
                    titles.add("y87tAFuD7jk");
                    titles.add("Ytw2xa30_Lo");
                    titles.add("YSc8wz4Ygo4");
                    titles.add("wF44ubxsxFE");
                    titles.add("70uU3wR59vc");
                    titles.add("Koz3W4wqMC4");
                    titles.add("e5SR4C7aPMg");
                    titles.add("efRLOnFVo6Y");
                    titles.add("TOmoMSm1hk4");
                    titles.add("bVjto3sQ9ek");
                    titles.add("USgbpS0IlAE");
                    titles.add("SyuP_e93ASM");
                    titles.add("tM8i-Q39jwE");
                    titles.add("9L2TQaOtFUg");
                    break;

                case 6:
                    titles.add("spiUa3VWJPA");titles.add("k9BZtZq9TGc");
                    titles.add("3EwJYvjzOfU");titles.add("1Mjkf5jRaLg");
                    titles.add("JZMQX9OeF7I");titles.add("_lgeHARi7pc");
                    titles.add("yGg8CenEG8k");titles.add("mkE3w5tQnyQ");
                    titles.add("e2mGbtWx7ow");titles.add("wGSvteUWWsE");
                    titles.add("Yf3HruyJ5is");titles.add("J3H82QW3cpc");
                    titles.add("PHPKwIcPcBY");titles.add("RRdSLS5W0NE");
                    titles.add("_EFQJ980Q9k");titles.add("z7oMrYubtzo");
                    titles.add("C6LtieyPOIE");titles.add("IDjH7KbtHDU");
                    titles.add("DrXRI-IE0Kg");titles.add("7A9ASdrpRmU");
                    titles.add("GJjiddcf-zM");titles.add("Uf0OkFpbOWA");
                    titles.add("LIocfM0VKLI");titles.add("9uEyvphCEeA");
                    titles.add("gyiVrqpnUd4");titles.add("lu__wo6Z29U");
                    titles.add("xq4MPXbfsA0");titles.add("7OaQ4txPJSo");
                    titles.add("Rk-7jVTPm78");titles.add("HRO8aOcPqeo");
                    titles.add("7QVlDmrNzxk");titles.add("pDn2tmqj9vc");
                    titles.add("vQwrT6i-r0s");titles.add("YY3rmSTj-Es");
                    titles.add("J4vAWqqeV30");titles.add("QmmgKvFtXfc");
                    titles.add("X0ABnImh_n4");titles.add("STOVmq8oydU");
                    titles.add("WzLIuoJ3Ymk");titles.add("kUiYNmnLb0I");
                    titles.add("Clpe8BegESs");titles.add("eWYV3FPG5RM");
                    titles.add("ti9tSmf8aW8");titles.add("FQBfspp0K1I");
                    titles.add("gDCZX0QnJlE");titles.add("j-vFXqs7yKA");
                    titles.add("i6qYkYPUoWw");titles.add("HW12zRpBNsY");
                    titles.add("WTv2cvMyqaI");titles.add("KHxwl96OEOc");
                    titles.add("w7dvKdb4uKE");titles.add("UK1DCwG4oNA");
                    titles.add("dumAbChlTAw");titles.add("8agvThesbyU");
                    titles.add("OZYDGEV8_6g");titles.add("TYd9NMpPuAQ");
                    titles.add("Y35TBTBh9v4");titles.add("9ynP_PEMxRI");
                    titles.add("ATqQtd96mug");titles.add("tR1Y7JIn-OA");
                    titles.add("zGCeIUaN0Zs");titles.add("Eq6h-ISWX7s");
                    titles.add("37rr-idj6Bw");titles.add("17tvnJreMnA");
                    titles.add("KZxKDgtaPe0");titles.add("w949H2qkG9Y");
                    titles.add("hThqhmsGD0U");titles.add("ivXYbefbVFI");
                    titles.add("pNU6YcoVhd8");titles.add("S-FyfFjHJlg");
                    titles.add("--dAQt51-Vc");titles.add("YXRhu6hEtlc");
                    titles.add("XpEJ8IoUn-c");titles.add("1G4Ls4Zj1Fk");
                    titles.add("KmI7H9ki5FU");titles.add("9MuJFKqDnS0");
                    titles.add("58KRZu8EMgY");titles.add("xiUDZ30rsrs");
                    titles.add("kxyEUee72-0");titles.add("e4-JQc7G_gw");
                    titles.add("9FkNqEdD-Ck");titles.add("kk-Kf04CQnU");
                    titles.add("Tz1voTXD0R8");titles.add("x2oz5RvsFfU");
                    titles.add("zo3ABVhfTvM");titles.add("vRUSKCRZUx4");
                    titles.add("KSRWvHmGnto");

                    break;

                default:
                    return;
            }
        }else if(fromWhere==2){
            switch (whichContent){
                case  0:
                    titles.add("xcGppQgM4gM");
                    break;

                case 1:
                    titles.add("bUtGN4_4-7k");

                    break;
                case 2:
                    titles.add("cMSAilkeXNI");
                    break;
                case 3:
                    titles.add("XN5aFx0gZNg");
                    break;

                default:return;
            }
        }

        getYouTubePlayerProvider().initialize(DeveloperKey.DEVELOPER_KEY,this);
    }
    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider,
                                        YouTubePlayer player, boolean wasRestored) {
        if (!wasRestored) {
            player.cueVideo(titles.get(position));

            videoPlayer = player;
            videoPlayer.setOnFullscreenListener(new YouTubePlayer.OnFullscreenListener() {
                @Override
                public void onFullscreen(boolean _isFullScreen) {
                    fullScreen = _isFullScreen;
                }
            });
        }
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider,
                                        YouTubeInitializationResult errorReason) {
        if (errorReason.isUserRecoverableError()) {
            errorReason.getErrorDialog(this, RECOVERY_DIALOG_REQUEST).show();
        } else {
            String errorMessage = String.format(
                    getString(R.string.error_player), errorReason.toString());
            Toast.makeText(this, errorMessage, Toast.LENGTH_LONG).show();
        }
    }

    protected YouTubePlayer.Provider getYouTubePlayerProvider() {
        return (YouTubePlayerView) findViewById(R.id.youtube_view);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == RECOVERY_DIALOG_REQUEST) {
            // Retry initialization if user performed a recovery action
            getYouTubePlayerProvider().initialize(DeveloperKey.DEVELOPER_KEY, this);
        }
    }
    @Override
    public void onBackPressed(){
        if(fullScreen) {
            videoPlayer.setFullscreen(false);
        }
        else{
            super.onBackPressed();
        }

    }
    @Override
    protected void onStart(){
        super.onStart();
        GoogleAnalytics.getInstance(this).reportActivityStart(this);
    }
    @Override
    protected void onStop(){
        super.onStop();
        GoogleAnalytics.getInstance(this).reportActivityStop(this);
    }

}
