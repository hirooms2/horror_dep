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


        }
    };

    //*******************************************군대***********************************************

    public static ArrayList<Model> millitary2 = new ArrayList<Model>();
    public static ArrayList<MyData> millitary = new ArrayList<MyData>()
    {
        {

        }
    };

    //*******************************************실화***********************************************
    public static ArrayList<MyData> real = new ArrayList<MyData>(){
        {


        }
    };
    public static ArrayList<Model> real2 = new ArrayList<>();

    //*******************************************대학***********************************************

    public static ArrayList<MyData> college = new ArrayList<MyData>(){
        {


        }
    };
    public static ArrayList<Model> college2 = new ArrayList<Model>();


    //*******************************************Roar***********************************************
    public static List<MyData> lore = new ArrayList<MyData>()
    {
        {

        }
    };

    public static ArrayList<Model> lore2 = new ArrayList<Model>();


    //******************************************이무이*********************************************
    public static List<MyData> understand = new ArrayList<MyData>()
    {
        {


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

        }
    };
    public static ArrayList<Model> city2 = new ArrayList<Model>();

    //*******************************************만화*******************************************

    public static ArrayList<Model> cartoon2 = new ArrayList<>();
}
