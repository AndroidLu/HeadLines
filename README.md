# HeadLines
自动网上滚动的,类似于新闻头条
使用很简单
private List<View> mViews =new ArrayList<>();创建列表

one=View.inflate(MainActivity.this,R.layout.item_one,null);把你需要的view填充到列表里
two=View.inflate(MainActivity.this,R.layout.item_two,null);
mViews.add(one);
mViews.add(two);    

mHeadLines.setViews(mViews);   //把列表填充到数据里

mHeadLines.setItemClick(new HeadLine.ItemClick() {  //设置点击事件
     @Override
            public void onItemClick(int position, View view) {
                Log.e("CCC","chen"+position);
                Toast.makeText(MainActivity.this,"cc"+position,Toast.LENGTH_SHORT).show();
            }
        });
有什么问题私信我,谢谢!
