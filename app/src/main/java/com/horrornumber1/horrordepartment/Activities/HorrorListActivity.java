package com.horrornumber1.horrordepartment.Activities;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;
import com.horrornumber1.horrordepartment.CounsilClass.ListItem;
import com.horrornumber1.horrordepartment.CounsilClass.RecyclerItemClickListener;
import com.horrornumber1.horrordepartment.Module.ApplicationController;
import com.horrornumber1.horrordepartment.R;

import java.util.ArrayList;

public class
HorrorListActivity extends AppCompatActivity {

    Context mContext;

    RecyclerView recyclerView;
    RecyclerView.Adapter Adapter;
    RecyclerView.LayoutManager layoutManager;

    ArrayList<ListItem> items;

    int whichContent=-1;
    Intent from;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.counsil_horror_list);

        Tracker t = ((ApplicationController)getApplication()).getTracker(ApplicationController.TrackerName.APP_TRACKER);
        t.setScreenName("HorrorRadio Activity");
        t.send(new HitBuilders.AppViewBuilder().build());

        mContext = getApplicationContext();

        from = getIntent();

        whichContent = from.getIntExtra("whichContent", -1);

        recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);

        layoutManager = new StaggeredGridLayoutManager(2, GridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        items = new ArrayList<>();


        switch (whichContent){
            case 0:
                items.add(new ListItem(R.drawable.radio_main, "제1화 죽음을 보는 아이"));
                items.add(new ListItem(R.drawable.radio_main, "제2화 모텔에서..."));
                items.add(new ListItem(R.drawable.radio_main, "제3화 나막신"));
                items.add(new ListItem(R.drawable.radio_main, "제4화 다리 없는 귀신"));
                items.add(new ListItem(R.drawable.radio_main, "제5화 콘서트"));
                items.add(new ListItem(R.drawable.radio_main, "제6화 홍천 굴지리 물귀신"));
                items.add(new ListItem(R.drawable.radio_main, "제7화 분신사바"));
                items.add(new ListItem(R.drawable.radio_main, "제8화 할머니의 제사"));
                items.add(new ListItem(R.drawable.radio_main, "제9화 분향"));
                items.add(new ListItem(R.drawable.radio_main, "제10화 집에 엄마가 있다"));
                items.add(new ListItem(R.drawable.radio_main, "제11화 손수 만든 고양이 인형"));
                items.add(new ListItem(R.drawable.radio_main, "제12화 아파트 304동 105호"));
                items.add(new ListItem(R.drawable.radio_main, "제13화 수풀 속의 여자"));
                items.add(new ListItem(R.drawable.radio_main, "제14화 여자아이의 방문"));
                items.add(new ListItem(R.drawable.radio_main, "제15화 어느 집 화장실에서"));
                items.add(new ListItem(R.drawable.radio_main, "제16화 자정의 방문자 "));
                items.add(new ListItem(R.drawable.radio_main, "제17화 싸대기"));
                items.add(new ListItem(R.drawable.radio_main, "제18화 덤프트럭"));
                items.add(new ListItem(R.drawable.radio_main, "제19화 첫 직장에서 본 귀신"));
                items.add(new ListItem(R.drawable.radio_main, "제20화 10년 전 영덕에서.."));
                items.add(new ListItem(R.drawable.radio_main, "제21화 국민학교 선생"));
                items.add(new ListItem(R.drawable.radio_main, "제22화 동굴 속 할머니"));
                items.add(new ListItem(R.drawable.radio_main, "제23화 여자를 질질 끄는 남자들"));
                items.add(new ListItem(R.drawable.radio_main, "제24화 귀신 나무"));
                items.add(new ListItem(R.drawable.radio_main, "제25화 선생님의 스토킹"));
                items.add(new ListItem(R.drawable.radio_main, "제26화 공원 화장실"));
                items.add(new ListItem(R.drawable.radio_main, "제27화 굶어죽은 개"));
                items.add(new ListItem(R.drawable.radio_main, "제28화 엘레베이터 아줌마"));
                items.add(new ListItem(R.drawable.radio_main, "제29화 가장 무서운 생각"));
                items.add(new ListItem(R.drawable.radio_main, "제30화 게임 중독"));
                items.add(new ListItem(R.drawable.radio_main, "제31화 자살 지원자"));
                items.add(new ListItem(R.drawable.radio_main, "제32화 이상한 경험"));
                items.add(new ListItem(R.drawable.radio_main, "제33화 화장실 숨바꼭질"));
                items.add(new ListItem(R.drawable.radio_main, "제34화 오두막 아르바이트"));
                items.add(new ListItem(R.drawable.radio_main, "제35화 인천 국제공항"));
                items.add(new ListItem(R.drawable.radio_main, "제36화 새벽 2시에 걸려온 전화"));
                items.add(new ListItem(R.drawable.radio_main, "제37화 수박"));
                items.add(new ListItem(R.drawable.radio_main, "제38화 공포택시"));
                items.add(new ListItem(R.drawable.radio_main, "제39화 개와의 산책"));
                items.add(new ListItem(R.drawable.radio_main, "제40화 내 딸을 위하여"));
                items.add(new ListItem(R.drawable.radio_main, "제41화 두려움을 극복하는 방법"));
                items.add(new ListItem(R.drawable.radio_main, "제42화 웅덩이"));
                items.add(new ListItem(R.drawable.radio_main, "제43화 제발 술 때문이라고 하지마세요"));
                items.add(new ListItem(R.drawable.radio_main, "제44화 내가 6살 때 했던 짓"));
                items.add(new ListItem(R.drawable.radio_main, "제45화 헌병 시절에 겪었던 실화"));
                items.add(new ListItem(R.drawable.radio_main, "제46화 나홀로 숨바꼭질"));
                items.add(new ListItem(R.drawable.radio_main, "제47화 개그맨 염경환의 실화"));
                items.add(new ListItem(R.drawable.radio_main, "제48화 M교수 낚시터 썰"));
                items.add(new ListItem(R.drawable.radio_main, "제49화 귀신보다 무서운 것"));
                items.add(new ListItem(R.drawable.radio_main, "제50화 반지하 원룸에서"));

                break;
            case 1:
                items.add(new ListItem(R.drawable.adult_radio, "제1화 훌라후프 1부"));
                items.add(new ListItem(R.drawable.adult_radio, "제2화 훌라후프 2부"));
                items.add(new ListItem(R.drawable.adult_radio, "제3화 포르노에서 아는 여자애를 봤습니다"));
                items.add(new ListItem(R.drawable.adult_radio, "제4화 방송실 괴담"));
                items.add(new ListItem(R.drawable.adult_radio, "제5화 어드벤쳐 게임"));
                items.add(new ListItem(R.drawable.adult_radio, "제6화 사랑의 결실"));
                items.add(new ListItem(R.drawable.adult_radio, "제7화 티켓 다방"));
                items.add(new ListItem(R.drawable.adult_radio, "제8화 매춘부와 남자"));
                items.add(new ListItem(R.drawable.adult_radio, "제9화 믹스주스"));
                items.add(new ListItem(R.drawable.adult_radio, "제10화 화류계 3대괴담"));
                items.add(new ListItem(R.drawable.adult_radio, "제11화 성인사이트"));
                items.add(new ListItem(R.drawable.adult_radio, "제12화 귀접"));
                items.add(new ListItem(R.drawable.adult_radio, "제13화 김진홍님 경험담"));
                items.add(new ListItem(R.drawable.adult_radio, "제14화 목욕탕을 훔쳐보다"));
                items.add(new ListItem(R.drawable.adult_radio, "제15화 결혼은 신중히..."));

                break;
            case 2:
                items.add(new ListItem(R.drawable.my_honey, "제1화 첫 만남"));
                items.add(new ListItem(R.drawable.my_honey, "제2화 바래다주는 길"));
                items.add(new ListItem(R.drawable.my_honey, "제3화 맛집 데이트"));
                items.add(new ListItem(R.drawable.my_honey, "제4화 그녀의 상처"));
                items.add(new ListItem(R.drawable.my_honey, "제5화 첫 날 밤"));
                items.add(new ListItem(R.drawable.my_honey, "제6화 결혼 못할걸?"));
                items.add(new ListItem(R.drawable.my_honey, "제7화 마법에 걸린날"));
                break;
            case 3:
                items.add(new ListItem(R.drawable.follower_story, "제1화 귀신 보는 언니"));
                items.add(new ListItem(R.drawable.follower_story, "제2화 납치"));
                items.add(new ListItem(R.drawable.follower_story, "제3화 폭풍이 지나간 후가 진짜 공포"));
                items.add(new ListItem(R.drawable.follower_story, "제4화 엄마와 나"));
                items.add(new ListItem(R.drawable.follower_story, "제5화 동영상"));
                items.add(new ListItem(R.drawable.follower_story, "제6화 귀신이 보고 싶다"));
                items.add(new ListItem(R.drawable.follower_story, "제7화 2-4 초소"));
                items.add(new ListItem(R.drawable.follower_story, "제8화 또따띠또"));
                items.add(new ListItem(R.drawable.follower_story, "제9화 수련원"));
                items.add(new ListItem(R.drawable.follower_story, "제10화 같이 있었다"));
                items.add(new ListItem(R.drawable.follower_story, "제11화 증조 할머니"));
                items.add(new ListItem(R.drawable.follower_story, "제12화 분신사바"));
                items.add(new ListItem(R.drawable.follower_story, "제13화 할아버지의 손짓"));
                items.add(new ListItem(R.drawable.follower_story, "제14화 주유소 아르바이트"));
                items.add(new ListItem(R.drawable.follower_story, "제15화 피범벅"));
                items.add(new ListItem(R.drawable.follower_story, "제16화 기숙학원"));
                items.add(new ListItem(R.drawable.follower_story, "제17화 내게 보이는 것"));
                items.add(new ListItem(R.drawable.follower_story, "제18화 탄약고 근무"));
                break;
            case 4:
                items.add(new ListItem(R.drawable.strange_story, "제1화 A군과 형"));
                items.add(new ListItem(R.drawable.strange_story, "제2화 그녀의 아버지"));
                items.add(new ListItem(R.drawable.strange_story, "제3화 내 친구 주희"));
                items.add(new ListItem(R.drawable.strange_story, "제4화 무덤 넓히기"));
                items.add(new ListItem(R.drawable.strange_story, "제5화 토막 살인"));
                items.add(new ListItem(R.drawable.strange_story, "제6화 틈새 귀신"));
                items.add(new ListItem(R.drawable.strange_story, "제7화 2층집 불"));
                items.add(new ListItem(R.drawable.strange_story, "제8화 귀신과 대화하는 방법"));
                items.add(new ListItem(R.drawable.strange_story, "제9화 머리"));
                items.add(new ListItem(R.drawable.strange_story, "제10화 반장"));
                items.add(new ListItem(R.drawable.strange_story, "제11화 숨바꼭질"));
                items.add(new ListItem(R.drawable.strange_story, "제12화 피부박피"));
                items.add(new ListItem(R.drawable.strange_story, "제13화 BB탄"));
                items.add(new ListItem(R.drawable.strange_story, "제14화 발렌타인 데이"));
                items.add(new ListItem(R.drawable.strange_story, "제15화 피범벅"));
                items.add(new ListItem(R.drawable.strange_story, "제16화 기숙학원"));
                items.add(new ListItem(R.drawable.strange_story, "제17화 부처"));
                items.add(new ListItem(R.drawable.strange_story, "제18화 여자친구의 전화"));
                items.add(new ListItem(R.drawable.strange_story, "제19화 유명한 괴담 모음"));
                items.add(new ListItem(R.drawable.strange_story, "제20화 중앙선 전철"));
                items.add(new ListItem(R.drawable.strange_story, "제21화 지네 설화"));
                items.add(new ListItem(R.drawable.strange_story, "제22화 토끼씨"));
                items.add(new ListItem(R.drawable.strange_story, "제23화 공포학과에서 일을 하면"));
                items.add(new ListItem(R.drawable.strange_story, "제24화 내가 두살 때"));
                items.add(new ListItem(R.drawable.strange_story, "제25화 민박집"));
                items.add(new ListItem(R.drawable.strange_story, "제26화 부산의 귀신 이야기"));
                items.add(new ListItem(R.drawable.strange_story, "제27화 아는 누나"));
                items.add(new ListItem(R.drawable.strange_story, "제28화 이상한 택시"));
                items.add(new ListItem(R.drawable.strange_story, "제29화 콧노래"));
                items.add(new ListItem(R.drawable.strange_story, "제30화 허언증"));
                items.add(new ListItem(R.drawable.strange_story, "제31화 친척 아줌마"));
                items.add(new ListItem(R.drawable.strange_story, "제32화 피아노를 치지 않는 이유"));
                items.add(new ListItem(R.drawable.strange_story, "제33화 고양이"));
                items.add(new ListItem(R.drawable.strange_story, "제34화 뒷모습"));
                items.add(new ListItem(R.drawable.strange_story, "제35화 문고리"));
                items.add(new ListItem(R.drawable.strange_story, "제36화 아파트"));
                items.add(new ListItem(R.drawable.strange_story, "제37화 자취방"));
                items.add(new ListItem(R.drawable.strange_story, "제38화 잠자리의 무언가"));
                items.add(new ListItem(R.drawable.strange_story, "제39화 지하철 역"));
                items.add(new ListItem(R.drawable.strange_story, "제40화 한밤 중의 소녀"));
                items.add(new ListItem(R.drawable.strange_story, "제41화 니 아들들을 내놓아라"));
                items.add(new ListItem(R.drawable.strange_story, "제42화 다잉 메시지"));
                items.add(new ListItem(R.drawable.strange_story, "제43화 변해간다는 것은"));
                items.add(new ListItem(R.drawable.strange_story, "제44화 사라진 손"));
                items.add(new ListItem(R.drawable.strange_story, "제45화 장례식장"));
                items.add(new ListItem(R.drawable.strange_story, "제46화 저승사자의 유형"));
                items.add(new ListItem(R.drawable.strange_story, "제47화 제사상과 두부"));
                items.add(new ListItem(R.drawable.strange_story, "제48화 친구"));
                items.add(new ListItem(R.drawable.strange_story, "제49화 케이블 해체"));
                items.add(new ListItem(R.drawable.strange_story, "제50화 텅 빈 쓰레기통"));
                items.add(new ListItem(R.drawable.strange_story, "제51화 화상"));
                items.add(new ListItem(R.drawable.strange_story, "제52화 흙인형"));
                items.add(new ListItem(R.drawable.strange_story, "제54화 결벽증"));
                items.add(new ListItem(R.drawable.strange_story, "제56화 목"));
                items.add(new ListItem(R.drawable.strange_story, "제57화 미녀의 초상화"));
                items.add(new ListItem(R.drawable.strange_story, "제58화 삐삐"));
                items.add(new ListItem(R.drawable.strange_story, "제59화 예쁜 여자"));
                items.add(new ListItem(R.drawable.strange_story, "제60화 우연"));
                items.add(new ListItem(R.drawable.strange_story, "제61화 자살하려는 찰나"));
                items.add(new ListItem(R.drawable.strange_story, "제62화 전 여자친구"));
                items.add(new ListItem(R.drawable.strange_story, "제63화 죽은 남자친구가 나와요"));
                items.add(new ListItem(R.drawable.strange_story, "제64화 차사고"));
                items.add(new ListItem(R.drawable.strange_story, "제65화 친구의 고백"));
                items.add(new ListItem(R.drawable.strange_story, "제66화 한밤 중의 교실"));
                items.add(new ListItem(R.drawable.strange_story, "제67화 할머니의 입원"));
                items.add(new ListItem(R.drawable.strange_story, "제68화 고등학교 졸업여행"));
                items.add(new ListItem(R.drawable.strange_story, "제69화 기차표"));
                items.add(new ListItem(R.drawable.strange_story, "제70화 끈질긴 영혼"));
                items.add(new ListItem(R.drawable.strange_story, "제71화 끝없는 복수"));
                items.add(new ListItem(R.drawable.strange_story, "제72화 도깨비 불"));
                items.add(new ListItem(R.drawable.strange_story, "제73화 동창회"));
                items.add(new ListItem(R.drawable.strange_story, "제74화 문자 스킬"));
                items.add(new ListItem(R.drawable.strange_story, "제75화 발렌타인데이"));
                items.add(new ListItem(R.drawable.strange_story, "제76화 버스를 기다리는 여자"));
                items.add(new ListItem(R.drawable.strange_story, "제77화 봉제인형"));
                items.add(new ListItem(R.drawable.strange_story, "제78화 불행을 부르는 자"));
                items.add(new ListItem(R.drawable.strange_story, "제81화 인류 마지막 날"));
                items.add(new ListItem(R.drawable.strange_story, "제82화 일주일만의 귀가"));
                items.add(new ListItem(R.drawable.strange_story, "제83화 저주 편지"));
                items.add(new ListItem(R.drawable.strange_story, "제84화 정당방위"));
                items.add(new ListItem(R.drawable.strange_story, "제85화 죽지마"));
                items.add(new ListItem(R.drawable.strange_story, "제86화 택시"));
                items.add(new ListItem(R.drawable.strange_story, "제87화 작은 덩어리"));
                items.add(new ListItem(R.drawable.strange_story, "제88화 중고차"));
                items.add(new ListItem(R.drawable.strange_story, "제89화 창밖의 여자아이"));
                break;

            case 5:
                items.add(new ListItem(R.drawable.city_story, "제1화 싸이코 패스"));
                items.add(new ListItem(R.drawable.city_story, "제2화 소방관 남편"));
                items.add(new ListItem(R.drawable.city_story, "제3화 윗집"));
                items.add(new ListItem(R.drawable.city_story, "제4화 이상한 할머니"));
                items.add(new ListItem(R.drawable.city_story, "제5화 임상병리사"));
                items.add(new ListItem(R.drawable.city_story, "제6화 입 찢는 여자"));
                items.add(new ListItem(R.drawable.city_story, "제7화 화장실의 아저씨"));
                items.add(new ListItem(R.drawable.city_story, "제8화 강제 헌혈"));
                items.add(new ListItem(R.drawable.city_story, "제9화 고기"));
                items.add(new ListItem(R.drawable.city_story, "제10화 데자뷰"));
                items.add(new ListItem(R.drawable.city_story, "제11화 생명의 은인"));
                items.add(new ListItem(R.drawable.city_story, "제12화 선인장"));
                items.add(new ListItem(R.drawable.city_story, "제13화 이상한 택시"));
                items.add(new ListItem(R.drawable.city_story, "제14화 짧은 괴담 모음"));
                items.add(new ListItem(R.drawable.city_story, "제15화 파칭코"));
                items.add(new ListItem(R.drawable.city_story, "제16화 긴팔만 입는 놈"));
                items.add(new ListItem(R.drawable.city_story, "제17화 물침대"));
                items.add(new ListItem(R.drawable.city_story, "제18화 아오키가하라"));
                items.add(new ListItem(R.drawable.city_story, "제19화 여의사"));
                items.add(new ListItem(R.drawable.city_story, "제20화 여자아이"));
                items.add(new ListItem(R.drawable.city_story, "제21화 열대어"));
                items.add(new ListItem(R.drawable.city_story, "제22화 점"));
                items.add(new ListItem(R.drawable.city_story, "제23화 형 뭐해?"));
                items.add(new ListItem(R.drawable.city_story, "제24화 소개팅"));
                items.add(new ListItem(R.drawable.city_story, "제25화 손님"));
                items.add(new ListItem(R.drawable.city_story, "제26화 여고생"));
                items.add(new ListItem(R.drawable.city_story, "제27화 우리집 옆"));
                items.add(new ListItem(R.drawable.city_story, "제28화 한 분 더 타실 수 있습니다"));
                items.add(new ListItem(R.drawable.city_story, "제29화 훈계"));
                items.add(new ListItem(R.drawable.city_story, "제30화 담배"));
                items.add(new ListItem(R.drawable.city_story, "제31화 맨션"));
                items.add(new ListItem(R.drawable.city_story, "제32화 화장실"));
                items.add(new ListItem(R.drawable.city_story, "제33화 가위에 자주 눌리는 친구"));
                items.add(new ListItem(R.drawable.city_story, "제34화 너냐?"));
                items.add(new ListItem(R.drawable.city_story, "제35화 드라이브"));
                items.add(new ListItem(R.drawable.city_story, "제36화 빌라 옥상"));
                items.add(new ListItem(R.drawable.city_story, "제37화 신문"));
                items.add(new ListItem(R.drawable.city_story, "제38화 지명수배자"));
                items.add(new ListItem(R.drawable.city_story, "제39화 친절하지 마세요"));
                items.add(new ListItem(R.drawable.city_story, "제40화 동기 두 명"));
                items.add(new ListItem(R.drawable.city_story, "제41화 문 열어!"));
                items.add(new ListItem(R.drawable.city_story, "제42화 바다는 어느쪽인가요"));
                items.add(new ListItem(R.drawable.city_story, "제43화 삶의 의지"));
                items.add(new ListItem(R.drawable.city_story, "제44화 삼풍백화점"));
                items.add(new ListItem(R.drawable.city_story, "제45화 수호령"));
                items.add(new ListItem(R.drawable.city_story, "제46화 안전요원"));
                items.add(new ListItem(R.drawable.city_story, "제47화 원망 받는 그녀"));
                items.add(new ListItem(R.drawable.city_story, "제48화 인신매매"));
                items.add(new ListItem(R.drawable.city_story, "제49화 자존심 싸움"));
                items.add(new ListItem(R.drawable.city_story, "제51화 지하실 창문"));
                items.add(new ListItem(R.drawable.city_story, "제52화 할아버지의 비밀"));
                items.add(new ListItem(R.drawable.city_story, "제53화 흙무덤"));
                items.add(new ListItem(R.drawable.city_story, "제54화 10살 어린 여친"));
                items.add(new ListItem(R.drawable.city_story, "제55화 경찰관의 지시"));
                items.add(new ListItem(R.drawable.city_story, "제56화 귓가에서 들리는 소리"));
                items.add(new ListItem(R.drawable.city_story, "제57화 돌연사"));
                items.add(new ListItem(R.drawable.city_story, "제59화 이거 줘!"));
                items.add(new ListItem(R.drawable.city_story, "제60화 이제 보인다"));
                items.add(new ListItem(R.drawable.city_story, "제61화 자살하려고 마음 먹었다"));
                items.add(new ListItem(R.drawable.city_story, "제62화 전염되는 감정"));
                items.add(new ListItem(R.drawable.city_story, "제63화 집에서 나갈 수가 없다"));
                items.add(new ListItem(R.drawable.city_story, "제64화 천장의 모습"));
                items.add(new ListItem(R.drawable.city_story, "제65화 친한 삼촌"));
                items.add(new ListItem(R.drawable.city_story, "제66화 풍경화"));
                items.add(new ListItem(R.drawable.city_story, "제67화 현관 앞의 꽃"));
                items.add(new ListItem(R.drawable.city_story, "제68화 흉가 근처 편의점"));
                items.add(new ListItem(R.drawable.city_story, "제69화 공중 전화박스"));
                items.add(new ListItem(R.drawable.city_story, "제70화 교도소 이야기"));
                items.add(new ListItem(R.drawable.city_story, "제71화 낯선남자"));
                items.add(new ListItem(R.drawable.city_story, "제72화 냄비요리"));
                items.add(new ListItem(R.drawable.city_story, "제73화 다진 고기"));
                items.add(new ListItem(R.drawable.city_story, "제74화 배 속의 못"));
                items.add(new ListItem(R.drawable.city_story, "제75화 사이버 드러그 1부"));
                items.add(new ListItem(R.drawable.city_story, "제76화 사이버 드러그 2부"));
                items.add(new ListItem(R.drawable.city_story, "제77화 상자 속의 여자아이 1부"));
                items.add(new ListItem(R.drawable.city_story, "제78화 상자 속의 여자아이 2부"));
                items.add(new ListItem(R.drawable.city_story, "제79화 악수 그리고..."));
                items.add(new ListItem(R.drawable.city_story, "제81화 원한 서린 길 1부"));
                items.add(new ListItem(R.drawable.city_story, "제82화 원한 서린 길 2부"));
                items.add(new ListItem(R.drawable.city_story, "제83화 절망적인 영화의 주인공"));
                items.add(new ListItem(R.drawable.city_story, "제84화 지문"));
                items.add(new ListItem(R.drawable.city_story, "제85화 째려보는 사람들"));
                items.add(new ListItem(R.drawable.city_story, "제86화 틈새로 보이던 것"));
                items.add(new ListItem(R.drawable.city_story, "제87화 피라냐"));
                items.add(new ListItem(R.drawable.city_story, "제88화 현수교"));
                break;

            case 6:
                items.add(new ListItem(R.drawable.horror_story, "제1화 간식"));
                items.add(new ListItem(R.drawable.horror_story, "제2화 간현 관광지"));
                items.add(new ListItem(R.drawable.horror_story, "제3화 유언 비디오"));
                items.add(new ListItem(R.drawable.horror_story, "제4화 남자의 사인"));
                items.add(new ListItem(R.drawable.horror_story, "제5화 병원 비상계단"));
                items.add(new ListItem(R.drawable.horror_story, "제6화 병원 화장실"));
                items.add(new ListItem(R.drawable.horror_story, "제7화 저 손님 무서워"));
                items.add(new ListItem(R.drawable.horror_story, "제8화 할머니의 일기"));
                items.add(new ListItem(R.drawable.horror_story, "제9화 결혼하면 같이 살래"));
                items.add(new ListItem(R.drawable.horror_story, "제10화 낚시터"));
                items.add(new ListItem(R.drawable.horror_story, "제11화 떨어지는 아이"));
                items.add(new ListItem(R.drawable.horror_story, "제12화 말기 암 환자"));
                items.add(new ListItem(R.drawable.horror_story, "제13화 신고자"));
                items.add(new ListItem(R.drawable.horror_story, "제14화 일기"));
                items.add(new ListItem(R.drawable.horror_story, "제15화 지하철"));
                items.add(new ListItem(R.drawable.horror_story, "제16화 대학교 중간고사"));
                items.add(new ListItem(R.drawable.horror_story, "제17화 더러워진 옷"));
                items.add(new ListItem(R.drawable.horror_story, "제18화 사촌동생의 꿈"));
                items.add(new ListItem(R.drawable.horror_story, "제19화 오고있다"));
                items.add(new ListItem(R.drawable.horror_story, "제20화 태국여행"));
                items.add(new ListItem(R.drawable.horror_story, "제21화 맛있는 물"));
                items.add(new ListItem(R.drawable.horror_story, "제22화 맹인 스님"));
                items.add(new ListItem(R.drawable.horror_story, "제23화 PC방"));
                items.add(new ListItem(R.drawable.horror_story, "제24화 그 여자를 따라갔다"));
                items.add(new ListItem(R.drawable.horror_story, "제25화 데리고 간다"));
                items.add(new ListItem(R.drawable.horror_story, "제26화 딸기소녀"));
                items.add(new ListItem(R.drawable.horror_story, "제27화 미술관"));
                items.add(new ListItem(R.drawable.horror_story, "제28화 싱글벙글 아줌마"));
                items.add(new ListItem(R.drawable.horror_story, "제29화 어머니와 아들"));
                items.add(new ListItem(R.drawable.horror_story, "제30화 인디영화"));
                items.add(new ListItem(R.drawable.horror_story, "제31화 커플"));
                items.add(new ListItem(R.drawable.horror_story, "제32화 꿈 속의 그녀"));
                items.add(new ListItem(R.drawable.horror_story, "제33화 PX 사고 사례"));
                items.add(new ListItem(R.drawable.horror_story, "제34화 떠다니는 목"));
                items.add(new ListItem(R.drawable.horror_story, "제35화 발렌타인데이"));
                items.add(new ListItem(R.drawable.horror_story, "제36화 발자국 소리"));
                items.add(new ListItem(R.drawable.horror_story, "제37화 방에 켜진 불"));
                items.add(new ListItem(R.drawable.horror_story, "제38화 엘리베이터"));
                items.add(new ListItem(R.drawable.horror_story, "제39화 저승사자는 있다"));
                items.add(new ListItem(R.drawable.horror_story, "제40화 굿"));
                items.add(new ListItem(R.drawable.horror_story, "제41화 귀신 들린 집"));
                items.add(new ListItem(R.drawable.horror_story, "제42화 꿈 속에서"));
                items.add(new ListItem(R.drawable.horror_story, "제43화 낡은 의자"));
                items.add(new ListItem(R.drawable.horror_story, "제44화 도움"));
                items.add(new ListItem(R.drawable.horror_story, "제45화 물 위의 그녀"));
                items.add(new ListItem(R.drawable.horror_story, "제46화 속삭임"));
                items.add(new ListItem(R.drawable.horror_story, "제47화 수박이 익는 계절"));
                items.add(new ListItem(R.drawable.horror_story, "제48화 아버지의 비밀"));
                items.add(new ListItem(R.drawable.horror_story, "제49화 엄마 거기 있어요?"));
                items.add(new ListItem(R.drawable.horror_story, "제50화 익사체를 마주하다"));
                items.add(new ListItem(R.drawable.horror_story, "제51화 저승사자의 방문"));
                items.add(new ListItem(R.drawable.horror_story, "제52화 저승이"));
                items.add(new ListItem(R.drawable.horror_story, "제53화 햄버거"));
                items.add(new ListItem(R.drawable.horror_story, "제54화 기분 나쁜 곳"));
                items.add(new ListItem(R.drawable.horror_story, "제55화 대학교 축제"));
                items.add(new ListItem(R.drawable.horror_story, "제56화 등산"));
                items.add(new ListItem(R.drawable.horror_story, "제57화 뜀틀"));
                items.add(new ListItem(R.drawable.horror_story, "제58화 물고기 꿈"));
                items.add(new ListItem(R.drawable.horror_story, "제59화 아귀"));
                items.add(new ListItem(R.drawable.horror_story, "제60화 안 좋은 소문이 도는 집"));
                items.add(new ListItem(R.drawable.horror_story, "제61화 엿"));
                items.add(new ListItem(R.drawable.horror_story, "제62화 영혼에게 보이는 것"));
                items.add(new ListItem(R.drawable.horror_story, "제63화 예쁜 머리카락"));
                items.add(new ListItem(R.drawable.horror_story, "제64화 외팔이 남자"));
                items.add(new ListItem(R.drawable.horror_story, "제65화 유조선 파이프 점검"));
                items.add(new ListItem(R.drawable.horror_story, "제66화 자수한 이유"));
                items.add(new ListItem(R.drawable.horror_story, "제67화 차 안의 오빠"));
                items.add(new ListItem(R.drawable.horror_story, "제68화 친절한 선배"));
                items.add(new ListItem(R.drawable.horror_story, "제69화 눈동자"));
                items.add(new ListItem(R.drawable.horror_story, "제71화 드럼통"));
                items.add(new ListItem(R.drawable.horror_story, "제72화 몇 명"));
                items.add(new ListItem(R.drawable.horror_story, "제73화 물에 빠진 것"));
                items.add(new ListItem(R.drawable.horror_story, "제75화 베란다에 하얀 것"));
                items.add(new ListItem(R.drawable.horror_story, "제76화 백미러에 비친 것"));
                items.add(new ListItem(R.drawable.horror_story, "제77화 빗소리"));
                items.add(new ListItem(R.drawable.horror_story, "제78화 사라진 친구"));
                items.add(new ListItem(R.drawable.horror_story, "제79화 살인마"));
                items.add(new ListItem(R.drawable.horror_story, "제80화 삼청교육대"));
                items.add(new ListItem(R.drawable.horror_story, "제81화 아무것도 필요없어"));
                items.add(new ListItem(R.drawable.horror_story, "제82화 어느 장의사의 이야기"));
                items.add(new ListItem(R.drawable.horror_story, "제83화 오래된 나무"));
                items.add(new ListItem(R.drawable.horror_story, "제84화 음악실 창문 너머"));
                items.add(new ListItem(R.drawable.horror_story, "제85화 이사"));
                items.add(new ListItem(R.drawable.horror_story, "제86화 이상한 버릇"));
                items.add(new ListItem(R.drawable.horror_story, "제87화 이상한 조언"));
                items.add(new ListItem(R.drawable.horror_story, "제88화 인적이 드문 화장실"));
                items.add(new ListItem(R.drawable.horror_story, "제89화 자각몽"));

                break;

            default:return;

        }
        Adapter = new ListAdapter(items, mContext);
        recyclerView.setAdapter(Adapter);

        recyclerView.addOnItemTouchListener( new RecyclerItemClickListener(mContext, recyclerView ,new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {
                        Intent intent = new Intent(getApplicationContext(), YoutubeActivity.class);
                        intent.putExtra("whichContent", whichContent);
                        intent.putExtra("position", position);
                        intent.putExtra("fromWhere", 1);
                        startActivity(intent);
                    }
                })
        );
    }
    public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {
        private Context context;
        private ArrayList<ListItem> mItems;

        private int lastPosition = -1;

        public ListAdapter(ArrayList<ListItem> items, Context mContext) {
            mItems = items;
            context = mContext;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.countsil_item_cardview, parent, false);

            return new ViewHolder(v);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, final int position) {

            holder.imageView.setImageResource(mItems.get(position).image);
            holder.textView.setText(mItems.get(position).imagetitle);
            setAnimation(holder.imageView, position);

        }

        @Override
        public int getItemCount() {
            return mItems.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {

            public ImageView imageView;
            public TextView textView;

            public ViewHolder(View view) {
                super(view);
                imageView = (ImageView) view.findViewById(R.id.image);
                textView = (TextView) view.findViewById(R.id.imagetitle);
            }
        }

        private void setAnimation(View viewToAnimate, int position) {
            if (position > lastPosition) {
                Animation animation = AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left);
                viewToAnimate.startAnimation(animation);
                lastPosition = position;
            }
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
