package com.horrornumber1.horrordepartment.StaticData;

import android.media.MediaPlayer;

import com.horrornumber1.horrordepartment.DBManager;
import com.horrornumber1.horrordepartment.DataModel.Model;
import com.horrornumber1.horrordepartment.DataModel.Box;
import com.horrornumber1.horrordepartment.DataModel.MyData;
import com.horrornumber1.horrordepartment.R;

import java.util.ArrayList;
import java.util.List;

public class DataHouse {

    //*************************************ServerData**********************************************
    public static Box box = new Box();
    public static DBManager dbManager;
    //**************************************Background Music****************************************
    public static boolean musicCheck = true;
    public static MediaPlayer mp;

    //*********************************** Name  ***********************************************
    public static final List<String> title = new ArrayList<String>()
    {
        {
            add("지역괴담");
            add("군대괴담");
            add("실제이야기");
            add("대학괴담");
            //add("4컷 만화");
            add("로어");
            add("이해하면 무서운 이야기");
            add("도시괴담");
        }
    };
    //*********************************** sub  ***********************************************
    public static List<String> sub = new ArrayList<String>()
    {
        {
            add("우리 동네 무서운 이야기");
            add("잊을 수 없는 공포");
            add("실제로 있었던 무서운 이야기");
            add("20대의 아찔한 기억");
            //add("4컷의 공포 만화");
            add("출처를 알 수 없는 비밀");
            add("이해하면 무서운 이야기");
            add("현대의 민담");
        }
    };

    //************************************Drawer Navigation1****************************************

    //************************************Drawer Navigation2****************************************
    public static List<MyData> drawerData2 = new ArrayList<MyData>()
    {
        {
            add(new MyData("면담하기",R.drawable.consult_icon));
            add(new MyData("건의/제보", R.drawable.mail_icon));
            add(new MyData("보관함", R.drawable.favorite2));
        }
    };

    //*******************************************지역***********************************************

    public static ArrayList<Model> region2 = new ArrayList<Model>();
    public static ArrayList<MyData> region = new ArrayList<MyData>()
    {
        {
            add(new MyData("경기도 고양시 괴담",0,R.raw.region01));
            add(new MyData("서울 용산구 괴담",0,R.raw.region02));
            add(new MyData("서울 송파구 괴담",0,R.raw.region03));
            add(new MyData("서울 동대문구 괴담",0,R.raw.region04));
            add(new MyData("경기도 화성시 괴담",0,R.raw.region05));
            add(new MyData("경기도 평택시 괴담",0,R.raw.region06));
            add(new MyData("대전광역시 괴담",0,R.raw.region08));
            add(new MyData("충청남도 아산 괴담",0,R.raw.region07));
            add(new MyData("충청남도 아산 괴담2",0,R.raw.region09));
            add(new MyData("충청남도 천안 괴담",0,R.raw.region10));
            add(new MyData("충청남도 당진 괴담",0,R.raw.region11));
            add(new MyData("강원도 속초 괴담",0,R.raw.region12));
            add(new MyData("강원도 원주 괴담",0,R.raw.region13));
            add(new MyData("강원도 원주 괴담2",0,R.raw.region14));
            add(new MyData("경상북도 영주 괴담",0,R.raw.region15));
            add(new MyData("부산광역시 괴담",0,R.raw.region16));
            add(new MyData("대구광역시 괴담",0,R.raw.region17));
            add(new MyData("울산광역시 괴담",0,R.raw.region18));
            add(new MyData("대구광역시 괴담2",0,R.raw.region19));
            add(new MyData("부산광역시 괴담2",0,R.raw.region20));
            add(new MyData("전라남도 여수 괴담",0,R.raw.region21));
            add(new MyData("전라북도 전주 괴담",0,R.raw.region22));
            add(new MyData("전라남도 순천 괴담",0,R.raw.region23));
            add(new MyData("광주광역시 괴담",0,R.raw.region24));
            add(new MyData("제주 서귀포 괴담",0,R.raw.region25));


        }
    };

    //*******************************************군대***********************************************

    public static ArrayList<Model> millitary2 = new ArrayList<Model>();
    public static ArrayList<MyData> millitary = new ArrayList<MyData>()
    {
        {
            add(new MyData("육군 2사단-관심병사",0,R.raw.millitary01));
            add(new MyData("육군 3사단-비밀봉지",0,R.raw.millitary02));
            add(new MyData("육군 3사단-우리 부대는..",0,R.raw.millitary03));
            add(new MyData("육군 6사단-선임병과 후임",0,R.raw.millitary04));
            add(new MyData("육군 6사단-'초소 투입로'",0,R.raw.millitary05));
            add(new MyData("육군 7사단-이상한 경험들",0,R.raw.millitary06));
            add(new MyData("육군 7사단-순찰자",0,R.raw.millitary07));
            add(new MyData("육군 7사단-야외계단",0,R.raw.millitary08));
            add(new MyData("육군 15사단-밖을 배회하는 그 무엇",0,R.raw.millitary09));
            add(new MyData("육군 17사단-44초소",0,R.raw.millitary10));
            add(new MyData("육군 21사단-노랫소리",0,R.raw.millitary11));
            add(new MyData("육군 23사단-낫을 든 손",0,R.raw.millitary12));
            add(new MyData("육군 23사단-무전소리",0,R.raw.millitary13));
            add(new MyData("육군 25사단-바나나",0,R.raw.millitary14));
            add(new MyData("육군 28사단-난간",0,R.raw.millitary15));
            add(new MyData("육군 32사단-폭우",0,R.raw.millitary16));
            add(new MyData("육군 35사단-폐생활실",0,R.raw.millitary17));
            add(new MyData("육군 35사단-죽여줄까",0,R.raw.millitary18));
            add(new MyData("의무경찰-벽제 38생활실",0,R.raw.millitary19));
            add(new MyData("제 1야전 수송교육단",0,R.raw.millitary20));
            add(new MyData("공군-기초 군사 훈련단",0,R.raw.millitary21));
            add(new MyData("공군-완전군장귀신",0,R.raw.millitary22));
            add(new MyData("공군-훈련소 귀신",0,R.raw.millitary23));
            add(new MyData("공군-수원비행장",0,R.raw.millitary25));
            add(new MyData("공군-17 전투비행단",0,R.raw.millitary26));
            add(new MyData("해병대-나와 걷던 그 사람",0,R.raw.millitary27));
            add(new MyData("해병대-루시드 드림",0,R.raw.millitary28));
            add(new MyData("해병대-잡음",0,R.raw.millitary29));
            add(new MyData("해병대-고양이",0,R.raw.millitary30));
            add(new MyData("해병대-라이차 귀신",0,R.raw.millitary31));
            add(new MyData("해병대-해안포",0,R.raw.millitary32));
            add(new MyData("해병대-여자들",0,R.raw.millitary33));
        }
    };

    //*******************************************실화***********************************************
    public static ArrayList<MyData> real = new ArrayList<MyData>(){
        {
            add(new MyData("머리카락",0,R.raw.real01));
            add(new MyData("악몽",0,R.raw.real02));
            add(new MyData("자살명당",0,R.raw.real03));
            add(new MyData("인형",0,R.raw.real04));
            add(new MyData("오토바이",0,R.raw.real05));
            add(new MyData("관심병사",0,R.raw.real06));
            add(new MyData("나만의 방",0,R.raw.real07));
            add(new MyData("꿈",0,R.raw.real08));
            add(new MyData("사촌언니",0,R.raw.real09));
            add(new MyData("할아버지의 비밀",0,R.raw.real10));
            add(new MyData("암사동 양x마을 1편",0,R.raw.real11));
            add(new MyData("암사동 양x마을 2편",0,R.raw.real12));
            add(new MyData("위험한 초대",0,R.raw.real13));
            add(new MyData("누나 하룻밤만 재워주세요",0,R.raw.real14));
            add(new MyData("으드득",0,R.raw.real15));
            add(new MyData("싱글벙글 아줌마",0,R.raw.real16));
            add(new MyData("무당",0,R.raw.real17));
            add(new MyData("초인종 누르는 여자",0,R.raw.real18));
            add(new MyData("추리 문제",0,R.raw.real19));
            add(new MyData("기숙사",0,R.raw.real20));
            add(new MyData("현관 앞의 꽃",0,R.raw.real21));
            add(new MyData("크리스마스 선물",0,R.raw.real22));
            add(new MyData("화가",0,R.raw.real23));
            add(new MyData("고기",0,R.raw.real24));
            add(new MyData("따듯한 내 남자",0,R.raw.real25));
            add(new MyData("화장터",0,R.raw.real26));
            add(new MyData("계단 위의 소녀",0,R.raw.real27));
            add(new MyData("엘리베이터 장난",0,R.raw.real28));
            add(new MyData("다음 생애",0,R.raw.real29));
            add(new MyData("문 단속",0,R.raw.real30));
            add(new MyData("지금 돌아왔니?",0,R.raw.real31));
            add(new MyData("상처의 유래",0,R.raw.real32));
            add(new MyData("옆집 아저씨",0,R.raw.real33));
            add(new MyData("마을의 거지",0,R.raw.real34));
            add(new MyData("보이나요?",0,R.raw.real35));
            add(new MyData("자살의 순서",0,R.raw.real36));
            add(new MyData("침착한 남자",0,R.raw.real37));
            add(new MyData("완벽한 알리바이",0,R.raw.real38));
            add(new MyData("흉가의 글귀",0,R.raw.real39));
            add(new MyData("웃는 소녀",0,R.raw.real40));
            add(new MyData("엄마",0,R.raw.real41));
            add(new MyData("귀신과의 대화",0,R.raw.real42));
            add(new MyData("위인",0,R.raw.real43));
            add(new MyData("종이박스",0,R.raw.real44));
            add(new MyData("새벽의 이상한 소리",0,R.raw.real45));
            add(new MyData("아파트",0,R.raw.real46));
            add(new MyData("의사 경험담",0,R.raw.real47));
            add(new MyData("우리 아들 고쳐주세요",0,R.raw.real48));
            add(new MyData("자살하는 여자",0,R.raw.real49));
            add(new MyData("어렸을 때",0,R.raw.real50));

        }
    };
    public static ArrayList<Model> real2 = new ArrayList<>();

    //*******************************************대학***********************************************

    public static ArrayList<MyData> college = new ArrayList<MyData>(){
        {
            add(new MyData("부천시 K대학교 괴담", 0, R.raw.college01 ));
            add(new MyData("노원구 K대학교 괴담", 0, R.raw.college02 ));
            add(new MyData("포천시 D대학교 괴담", 0, R.raw.college03 ));
            add(new MyData("중구 D대학교 괴담", 0, R.raw.college04 ));
            add(new MyData("서대문구 M대학교 괴담", 0, R.raw.college05 ));
            add(new MyData("관악구 S대학교 괴담", 0, R.raw.college06));
            add(new MyData("서대문구 Y대학교 괴담", 0, R.raw.college07 ));
            add(new MyData("서대문구 E대학교 괴담", 0, R.raw.college08 ));
            add(new MyData("성동구 H대학교 괴담", 0, R.raw.college09 ));
            add(new MyData("마포구 H대학교 괴담", 0, R.raw.college10 ));
            add(new MyData("안성시 J대학교 괴담", 0, R.raw.college11 ));
            add(new MyData("천안시 D대학교 괴담", 0, R.raw.college13 ));
            add(new MyData("충청도 H대학교 괴담", 0, R.raw.college26 ));
            add(new MyData("청주시 C대학교 괴담", 0, R.raw.college15 ));
            add(new MyData("세종시 K대학교 괴담", 0, R.raw.college12 ));
            add(new MyData("춘천시 K대학교 괴담", 0, R.raw.college17 ));
            add(new MyData("춘천시 H대학교 괴담", 0, R.raw.college16 ));
            add(new MyData("사하구 D대학교 괴담", 0, R.raw.college19 ));
            add(new MyData("금정구 B대학교 괴담", 0, R.raw.college20 ));
            add(new MyData("영도구 H대학교 괴담", 0, R.raw.college21 ));
            add(new MyData("진주시 K대학교 괴담", 0, R.raw.college27 ));
            add(new MyData("광산시 K대학교 괴담", 0, R.raw.college22 ));
            add(new MyData("북구 J대학교 괴담", 0, R.raw.college23 ));
            add(new MyData("동구 C대학교 괴담", 0, R.raw.college24 ));
            add(new MyData("제주시 J대학교 괴담", 0, R.raw.college25 ));

        }
    };
    public static ArrayList<Model> college2 = new ArrayList<Model>();


    //*******************************************Roar***********************************************
    public static List<MyData> lore = new ArrayList<MyData>()
    {
        {
            add(new MyData("로어모음 하나",0, R.raw.lore01));
            add(new MyData("로어모음 둘", 0, R.raw.lore02));
            add(new MyData("로어모음 셋", 0, R.raw.lore03));
            add(new MyData("로어모음 넷", 0, R.raw.lore04));
            add(new MyData("로어모음 다섯", 0, R.raw.lore05));
            add(new MyData("로어모음 여섯", 0, R.raw.lore06));
            add(new MyData("로어모음 일곱", 0, R.raw.lore07));
            add(new MyData("로어모음 여덟", 0, R.raw.lore08));
            add(new MyData("로어모음 아홉", 0, R.raw.lore09));
            add(new MyData("로어모음 열", 0, R.raw.lore10));
            add(new MyData("로어모음 열하나", 0, R.raw.lore11));
            add(new MyData("로어모음 열둘", 0, R.raw.lore12));
            add(new MyData("로어모음 열셋", 0, R.raw.lore13));
            add(new MyData("로어모음 열넷", 0, R.raw.lore14));
            add(new MyData("로어모음 열다섯", 0, R.raw.lore15));
            add(new MyData("로어모음 열여섯", 0, R.raw.lore16));
            add(new MyData("로어모음 열일곱", 0, R.raw.lore17));
            add(new MyData("로어모음 열여덟", 0, R.raw.lore18));
            add(new MyData("로어모음 열아홉", 0, R.raw.lore19));
            add(new MyData("로어모음 스물", 0, R.raw.lore20));
            add(new MyData("로어모음 스물하나", 0, R.raw.lore21));
            add(new MyData("로어모음 스물둘", 0, R.raw.lore22));
            add(new MyData("로어모음 스물셋", 0, R.raw.lore23));
            add(new MyData("로어모음 스물넷", 0, R.raw.lore24));
            add(new MyData("로어모음 스물다섯", 0, R.raw.lore25));
            add(new MyData("로어모음 스물여섯",0, R.raw.lore26));
            add(new MyData("로어모음 스물일곱", 0, R.raw.lore27));
            add(new MyData("로어모음 스물여덟", 0, R.raw.lore28));
            add(new MyData("로어모음 스물아홉", 0, R.raw.lore29));
            add(new MyData("로어모음 서른", 0, R.raw.lore30));
            add(new MyData("로어모음 서른하나", 0, R.raw.lore31));
            add(new MyData("로어모음 서른둘", 0, R.raw.lore32));
            add(new MyData("로어모음 서른셋", 0, R.raw.lore33));
            add(new MyData("로어모음 서른넷", 0, R.raw.lore34));
            add(new MyData("로어모음 서른다섯", 0, R.raw.lore35));
            add(new MyData("로어모음 서른여섯", 0, R.raw.lore36));
            add(new MyData("로어모음 서른일곱", 0, R.raw.lore37));
            add(new MyData("로어모음 서른여덟", 0, R.raw.lore38));
            add(new MyData("로어모음 서른아홉", 0, R.raw.lore39));
            add(new MyData("로어모음 마흔", 0, R.raw.lore40));
            add(new MyData("로어모음 마흔하나", 0, R.raw.lore41));
            add(new MyData("로어모음 마흔둘", 0, R.raw.lore42));
            add(new MyData("로어모음 마흔셋", 0, R.raw.lore43));
            add(new MyData("로어모음 마흔넷", 0, R.raw.lore44));
            add(new MyData("로어모음 마흔다섯", 0, R.raw.lore45));
            add(new MyData("로어모음 마흔여섯", 0, R.raw.lore46));
            add(new MyData("로어모음 마흔일곱", 0, R.raw.lore47));
            add(new MyData("로어모음 마흔여덟", 0, R.raw.lore48));
            add(new MyData("로어모음 마흔아홉", 0, R.raw.lore49));
            add(new MyData("로어모음 쉰", 0, R.raw.lore50));
        }
    };

    public static ArrayList<Model> lore2 = new ArrayList<Model>();


    //******************************************이무이*********************************************
    public static List<MyData> understand = new ArrayList<MyData>()
    {
        {
            add(new MyData("나폴리탄",0, R.raw.imui01));
            add(new MyData("엄마의 시체",0, R.raw.imui02));
            add(new MyData("소원",0, R.raw.imui03));
            add(new MyData("게임",0, R.raw.imui04));
            add(new MyData("누군가 보고 있다",0, R.raw.imui05));
            add(new MyData("스토킹",0, R.raw.imui06));
            add(new MyData("상자",0, R.raw.imui07));
            add(new MyData("할머니",0, R.raw.imui08));
            add(new MyData("손금",0, R.raw.imui09));
            add(new MyData("초상화",0, R.raw.imui10));
            add(new MyData("우물",0, R.raw.imui11));
            add(new MyData("비상계단",0, R.raw.imui12));
            add(new MyData("일란성 쌍둥이",0, R.raw.imui13));
            add(new MyData("별님",0, R.raw.imui14));
            add(new MyData("연상녀",0, R.raw.imui15));
            add(new MyData("아들",0, R.raw.imui16));
            add(new MyData("캠프",0, R.raw.imui17));
            add(new MyData("뺑소니",0, R.raw.imui18));
            add(new MyData("흑인",0 , R.raw.imui19));
            add(new MyData("새엄마",0, R.raw.imui20));
            add(new MyData("우물",0, R.raw.imui21));
            add(new MyData("동영상",0, R.raw.imui22));
            add(new MyData("오빠",0, R.raw.imui23));
            add(new MyData("남자친구",0, R.raw.imui24));
            add(new MyData("수박",0, R.raw.imui25));
            add(new MyData("시간능력자",0, R.raw.imui26));
            add(new MyData("알바생",0, R.raw.imui27));
            add(new MyData("꿈",0, R.raw.imui28));
            add(new MyData("이상한 할머니",0, R.raw.imui29));
            add(new MyData("흙장난",0, R.raw.imui30));
            add(new MyData("노인",0, R.raw.imui31));
            add(new MyData("남편의 부탁",0, R.raw.imui32));
            add(new MyData("버스사고",0, R.raw.imui33));
            add(new MyData("베트남 전쟁",0, R.raw.imui34));
            add(new MyData("내 아이가 아니야",0, R.raw.imui35));
            add(new MyData("초콜릿",0, R.raw.imui36));
            add(new MyData("종이 비행기",0, R.raw.imui37));
            add(new MyData("22층",0, R.raw.imui38));
            add(new MyData("전화",0, R.raw.imui39));
            add(new MyData("복면의 남자",0, R.raw.imui40));
            add(new MyData("어머니",0, R.raw.imui41));
            add(new MyData("CCTV",0, R.raw.imui42));
            add(new MyData("양치질",0, R.raw.imui43));
            add(new MyData("제가 볼 수 있는 것은",0, R.raw.imui44));
            add(new MyData("입원실의 동료",0, R.raw.imui45));
            add(new MyData("시멘트",0, R.raw.imui46));
            add(new MyData("생리",0, R.raw.imui47));
            add(new MyData("가족의 비밀",0, R.raw.imui48));
            add(new MyData("포치",0, R.raw.imui49));
            add(new MyData("다시 그 자리로",0, R.raw.imui50));

        }
    };

    public static List<String> understandAnswer = new ArrayList<String>()
    {
        {
            add("산속 깊은 곳인데 인기 메뉴가 있을리가 없다. 사람을 죽여서 그 고기로 다시 나폴리탄을 만든 것");
            add("엄마의 잘못이 아닌 아빠가 미쳐서 살인을 저지른거고 그걸 눈치챈 엄마가 딸을 구하기 위해 죽기 전에 메모를 남김");
            add("소원을 들어주는 남자는 악마다. 그가 첫 소원을 들어주었을 때 '눈앞에 나타났다' 고 했다.\n" +
                    "소원을 들어준 후 그 여자의 눈을 가져갔고, 그 다음 소원을 들어주려 나타났을때 눈이 없으니 '소리가 들려왔다' 라고 나온다. \n" +
                    "소원을 들어준 후 또다시 여자의 귀를 가져갔다.\n" +
                    "그래서 다음 소원을 들어주려 여자 앞에 나타났을 때 여자는 귀가 없기 때문에 '대답하지 않았다.'라고 나온다.\n" +
                    "그래서 그 남자는 순서가 잘못 되었다고 말하는 것");
            add("남자는 상자 속에 갇혔다. 남자의 목이 잘려 돈과 함께 들어가 있다"); // 답변 넣기
            add("거울이랑 창문이 쌍으로 있으면 거울에 보이는 나는 분명히 등이 나와야 하는데 내 앞 모습이 비쳐 보인다");
            add("문이 열려 있었는데 내가 다시 문을 잠궜다는 이야기를 하지 않았음. 집안에 있는 누군가가 착하게 문단속 해줌");
            add("버튼을 내가 누름으로 인해서 어딘가에 있는 누군가가 죽었다. 근데 그 후에 먼 곳의 누군가 한테는 내가 '어딘가의 누군가'가 된다. 그 사람이 버튼을 누르면 내가 죽는것");
            add("죽은 할머니가 나타난게 무서운 이야기가 아니라 내 마지막 생일 축하. 난 이제 곧 죽을 것이다");
            add("생명줄 늘려서 손녀가 손주 아빠 엄마 생명을 다 받아서 오래 살게 된 것"); // 답변 넣기
            add("눈이 크고 아름답고 마치 나를 쳐다보는 느낌이 들었다. 근데 작품의 제목은 잠자는 미녀. \n" +
                    "딸의 잠자는 모습을 그림 것이므로 눈을 뜨고 있을리 없다");
            add("가족들이 고모를 살해한 후 시체를 우물에 넣어놨음. 딸은 혼자 막 돌아 다니다가 우물에서 시체를 발견한 것");
            add("항상 그 괴물이 엘레베이터에 나타나 다른 주민들도 같은 방법으로 도망을 쳤던 것");
            add("납치범이 지인이다. 일란성 쌍둥이인데 납치 하자마자 어떻게 언니 동생을 알 수 있을까");
            add("이 소녀는 입양 되었든지 해서 온 것이다. 지금 있는 가족은 친가족이 아님. 어딘가 있을 친가족이 죽은 것이다"); // 답변 넣기
            add("여자가 변기 커버를 올리지 않는다");
            add("티비를 켜기 전 검은 화면에 비친 나를 아이는 가리켰다");
            add("나는 밧줄에 대한 것을 언급하지 않았다.근데 친구는 알고있었다. 친구가 나를 죽이려고 일부로 밧줄을 끊었다");
            add("친구가 다음엔 진짜 병문안을 온다고 했는데,  병문안을 온것이 아니라면 친구는 무엇을 말하려고 온 것일까? 범인은 친구다");
            add("존은 흑인이다"); // 답변 넣기
            add("음 규칙을 어겼을 때 새엄마는 오른쪽 손을 잘랐다. 그래서 왼쪽으로 쓰는 것이 힘들었다. \n" +
                    "두 번째로 규칙을 어겼을 땐 왼쪽 손목을 잘라서 결국 입으로 쓰는 것. 그래서 대답하지 못했다. 연필을 입에 물고 있었기 때문에");
            add("우물 안은 귀신 천지");
            add("죽은 사람이 메일을 보내는 것은 불가능하다");
            add("사건의 범인은 여동생. 오빠는 여동생을 감싸고 스스로 사형당했다. 오빠가 죽인 한 사람은 자기 자신");
            add("여자친구가 쓰러진 장소를 어떻게 알았지?"); // 답변 넣기
            add("만약 그 수박이 익었더라면...?");
            add("시간이 멈춰진 사람들은 어떻게 하지?");
            add("그리고 나는 열쇠가 없다");
            add("베란다 난간 위에 올라가있었다");
            add("할머니가 목을 메 죽어있었던 것"); // 답변 넣기
            add("어머니의 흙장난이 시작된다");
            add("사람은 죽을때가되면 저승사자가 보인다");
            add("똑똑하군...");
            add("그들은 이미 죽기를 각오하고 놀러가고 있었던 것");
            add("아들이 말한 그 친구는 사실 자신을 말했던 것");
            add("산모가 그 아이를 깔아뭉개 죽였던 것");
            add("형을 죽이면 형만한 초콜릿을 받을수 있을거라 생각했다");
            add("안 나가면 죽인다");
            add("화장실을 가려고 22층까지 올라온다?");
            add("집에 누군가가 또 있는 것"); // 답변 넣기
            add("과연 복면의 남자가 죽였을까?");
            add("그동안 어머니가 시체를 처리해주었던 것");
            add("되감기를 했는데 떨어졌다는 것은...");
            add("남자는 면도칼로 양치질을 했다");
            add("잠시 후 그곳의 모든 사람들이 사망한다");
            add("그는 이미 죽었다. 마지막 배웅을 하기 위해 나타난 것");
            add("여자는 남편이 있는 곳에서 그를 따라 죽을 것이다");
            add("임신을 하느니 생리가 낫다. 둘은 근친 상간을 하는 오빠 동생 사이다");
            add("남자는 죽은 귀신이다");
            add("나를 핥았던 것은 포치가 아니다");
            add("남자는 다시 그 어머니의 아들이 되었다");
        }
    }; //답변 리스트
    public static ArrayList<Model> understand2 = new ArrayList<Model>();


    //*******************************************도시괴담*******************************************
    public static ArrayList<MyData> city = new ArrayList<MyData>()
    {
        {
            add(new MyData("신혼여행",0,R.raw.city01));
            add(new MyData("음료공장",0,R.raw.city02));
            add(new MyData("움직이지 않는 아기",0,R.raw.city03));
            add(new MyData("비디오의 여자",0,R.raw.city04));
            add(new MyData("한밤중의 노크",0,R.raw.city05));
            add(new MyData("강아지가 본 것",0,R.raw.city06));
            add(new MyData("전도",0,R.raw.city07));
            add(new MyData("손님",0,R.raw.city08));
            add(new MyData("공중화장실의 낙서",0,R.raw.city09));
            add(new MyData("우리 딸 보셨나요?",0,R.raw.city10));
            add(new MyData("왕따",0,R.raw.city11));
            add(new MyData("아들의 휴대폰",0,R.raw.city12));
            add(new MyData("도로의 여인",0,R.raw.city13));
            add(new MyData("장난전화",0,R.raw.city14));
            add(new MyData("정류장",0,R.raw.city15));
            add(new MyData("내가 떠난 여행",0,R.raw.city16));
            add(new MyData("승진",0,R.raw.city17));
            add(new MyData("이상한 전화",0,R.raw.city18));
            add(new MyData("흉가체험",0,R.raw.city19));
            add(new MyData("공원의 정자",0,R.raw.city20));
            add(new MyData("SOS 조난사건",0,R.raw.city21));
            add(new MyData("다른 세계로 가는 법",0,R.raw.city22));
            add(new MyData("몽유병",0,R.raw.city23));
            add(new MyData("초인종 괴담",0,R.raw.city24));
            add(new MyData("일본 도시전설-시라즈모리 신사",0,R.raw.city25));
            add(new MyData("아파트",0,R.raw.city26));
            add(new MyData("엄마의 눈물",0,R.raw.city27));
            add(new MyData("손님",0,R.raw.city28));
            add(new MyData("엘리베이터의 남자",0,R.raw.city29));
            add(new MyData("귀신을 보는 친구의 이야기",0,R.raw.city30));
            add(new MyData("주머니 속의 쪽지",0,R.raw.city31));
            add(new MyData("타임캡슐",0,R.raw.city32));
        }
    };
    public static ArrayList<Model> city2 = new ArrayList<Model>();

    //*******************************************만화*******************************************

    public static ArrayList<Model> cartoon2 = new ArrayList<>();
}
