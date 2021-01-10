package ClientPackage;


	import java.awt.EventQueue;

	public class InventoryRun {
		
		public static void main(String[] args) {

			EventQueue.invokeLater(new Runnable() {

				public void run() {
					try {

						InventoryGui view = new InventoryGui();

						InventoryManager model = new InventoryManager();

						InventoryController controller = new InventoryController(view, model);

						view.frame.setVisible(true);

					} catch (Exception e) {
						e.printStackTrace();
					}
				}

			});

		}


}
