package spider;


	public class Task implements Runnable {

//		±àºÅ
		int n;
		
		
		public Task(int n) {
		super();
		this.n = n;
		}


		@Override
		public void run() {
			// TODO Auto-generated method stub
			String name = Thread.currentThread().getName();
			System.out.println(name + "¿ªÊ¼ : " + n);
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(name + "½áÊø : " + n);
		}

}
