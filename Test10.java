/**
	�������������
	ʹ�ö�������ʵ�ֶ��Chicken�Ĺ���
	��̬���飺
	1.������һ���������ݽṹ
	2.���鲻�ʺ���ɾ������Ȳ������ʺ���ӣ����������ҡ�
*/





import java.util.Arrays;//����һ����
public class Test10{
	public static void main(String[] args){
	ChickenManager cm = new ChickenManager(5);

	cm.add(new Chicken(1,"СС",10));
	cm.add(new Chicken(2,"С��",5));
	cm.add(new Chicken(3,"С��",8));
	cm.add(new Chicken(4,"С��",6));
	cm.add(new Chicken(5,"С��",1));
	
	cm.add(new Chicken(6,"���",7));
	System.out.println("����ĳ�����:"+cm.length());
	System.out.println("-------printAll-------");
	cm.printAll();
	
	System.out.println("---------find---------------");
	Chicken c = cm.find(4);//��idΪ4��С�����ҳ����Ժ���Chicken���c�������
	c.print();
	System.out.println("-------update-----------------");
	cm.update(new Chicken(1,"�µ�����",22));
	cm.printAll();
	System.out.println("----------------delete-------------");
	cm.delete(3);
	cm.printAll();
	
}
}
//
  //С��������
class ChickenManager{ 
	
	private Chicken[] cs = null;
	private int count = 0;//��¼��ǰ�����Ԫ�ظ������±꣩
	
	public ChickenManager(int size){
		if(size>0){
			cs =new Chicken[size];
		}else{
			cs = new Chicken[5];
		}
	}
	public int length(){
		return cs.length;
	}
	//��ӣ�ʵ�ֶ�̬����
	public void add(Chicken c){
		       
		if(count>=cs.length){//������������Ҫ����	

			//�㷨1������ԭ�������С��һ�� cs.length*3/2+1
			//�㷨2������ԭ�������һ�� cs.length*2
		int newlen = cs.length*2;
		cs = Arrays.copyOf(cs,newlen);
		
	}
		cs[count] = c;
		count++;
	}
	//ɾ��
	public void delete(int id){
		
		for(int i=0;i<count;i++){
			if(cs[i].getId()==id){
				//�ҵ���Ҫɾ���Ķ��󣬰��Ҹö���֮��Ķ���ȫ����ǰŲһλ
				for(int j=i;j<count-1;j++){
					cs[j]=cs[j+1];
				}
				//�����һ������ֵΪ�գ�ɾ����
				cs[count-1] = null;
				count--;//�±��һ
				break;
			}
		}
	}
	//���£�id���䣬����id����С��������С�������������
	public void update(Chicken c){
		Chicken temp = find(c.getId());
		temp.setName(c.getName());
		temp.setAge(c.getAge());
	}
	//����
	public Chicken find(int id){
		for(int i=0;i<count;i++){
			if(cs[i].getId()==id){
				return cs[i];
			}
		}
		return null;
		}
	//�������
	public void printAll(){
		for(int i=0;i<count;i++){
			cs[i].print();
		}
	}
}

//С���ࣨ���ݹ���value object(vo)
class Chicken{
	

	private int id;
	private String name;
	private int age;
	public Chicken(){}//һ������±���Ĭ�ϵĹ��췽��
	public Chicken(int id,String name,int age ){
		this.id = id;
		this.name = name;
		this.age = age;
	
	}
	public void setId(int id){
		this.id = id;
	}
	public int getId(){
		return id;
	}
	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return name ;
	}
	public void setAge(int age ){
		this.age = age;
	}
	public int getAge(){
		return age ;
	}
	public void print(){
		System.out.println("id="+id+",name��"+name+",age="+age);
	}
	
}