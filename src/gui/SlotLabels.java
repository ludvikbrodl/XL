package gui;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.SwingConstants;

import model.Sheet;
import util.XLException;

@SuppressWarnings("serial")
public class SlotLabels extends GridPanel implements Observer {
    private List<SlotLabel> labelList;

    public SlotLabels(int rows, int cols, CurrentSlot currentSlot, Sheet sheet) {
        super(rows + 1, cols);
        sheet.addObserver(this);
        labelList = new ArrayList<SlotLabel>(rows * cols);
        for (char ch = 'A'; ch < 'A' + cols; ch++) {
            add(new ColoredLabel(Character.toString(ch), Color.LIGHT_GRAY,
                    SwingConstants.CENTER));
        }
        for (int row = 1; row <= rows; row++) {
            for (char ch = 'A'; ch < 'A' + cols; ch++) {
            	String address = ch+""+row;
                SlotLabel label = new SlotLabel(currentSlot, address);
                add(label);
                labelList.add(label);
            }
        }
        SlotLabel firstLabel = labelList.get(0);
        currentSlot.addObserver(firstLabel);
        currentSlot.updateCurrent(firstLabel.getAddress());
        firstLabel.setBackground(Color.YELLOW);
    }
    
    public List<SlotLabel> getLabeList() {
    	return labelList;
    }

	@Override
	public void update(Observable arg0, Object arg1) {
		Sheet sheet = (Sheet) arg0;
		for(SlotLabel slotLabel : labelList) {
			String address = slotLabel.getAddress();
			if(sheet.isComment(address))
				slotLabel.setText(sheet.toString(address).substring(1));
			else {
				try {
					slotLabel.setText(String.valueOf(sheet.value(address)));
				} catch (XLException e) {
					slotLabel.setText("");
				}
			}
		}
		
	}
}
