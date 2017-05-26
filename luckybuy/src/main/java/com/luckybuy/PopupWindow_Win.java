package com.luckybuy;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

/**
 * All rights Reserved, Designed By GeofferySun 
 * @Title: 	PopupWindow_Bask.java
 * @Package sun.geoffery.uploadpic 
 * @Description:�ӵײ������򻬳�ѡ��˵��򴰿�
 * @author:	GeofferySun   
 * @date:	2015��1��15�� ����1:21:01 
 * @version	V1.0
 */
public class PopupWindow_Win extends PopupWindow {

	private TextView issue,title;
	private ImageView cancelBtn;
	private View mMenuView;


	@SuppressLint("InflateParams")
	public PopupWindow_Win(Context context, OnClickListener itemsOnClick) {
		super(context);
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		mMenuView = inflater.inflate(R.layout.popwin_win_prize, null);
        issue = (TextView) mMenuView.findViewById(R.id.win_prize_issue_tv);
        title = (TextView) mMenuView.findViewById(R.id.win_prize_title_tv);
		cancelBtn = (ImageView) mMenuView.findViewById(R.id.win_prize_cancel_iv);
		// ���ð�ť����
		cancelBtn.setOnClickListener(itemsOnClick);
		
		// ����SelectPicPopupWindow��View
		this.setContentView(mMenuView);
		// ����SelectPicPopupWindow��������Ŀ�
		this.setWidth(LayoutParams.MATCH_PARENT);
		// ����SelectPicPopupWindow��������ĸ�
		this.setHeight(LayoutParams.MATCH_PARENT);
		// ����SelectPicPopupWindow��������ɵ��
		this.setFocusable(true);
		// ����SelectPicPopupWindow�������嶯��Ч��
		this.setAnimationStyle(R.style.PopupAnimation);
		// ʵ����һ��ColorDrawable��ɫΪ��͸��
		ColorDrawable dw = new ColorDrawable(0x80000000);
		// ����SelectPicPopupWindow��������ı���
		this.setBackgroundDrawable(dw);
		// mMenuView���OnTouchListener�����жϻ�ȡ����λ�������ѡ������������ٵ�����
		/*mMenuView.setOnTouchListener(new OnTouchListener() {

			@Override
			@SuppressLint("ClickableViewAccessibility")
			public boolean onTouch(View v, MotionEvent event) {

				int height = mMenuView.findViewById(R.id.pop_layout).getTop();
				int y = (int) event.getY();
				if (event.getAction() == MotionEvent.ACTION_UP) {
					if (y < height) {
						dismiss();
					}
				}
				return true;
			}
		});*/
	}

    public TextView getIssue() {
        return issue;
    }

    public void setIssue(TextView issue) {
        this.issue = issue;
    }

    public TextView getTitle() {
        return title;
    }

    public void setTitle(TextView title) {
        this.title = title;
    }
}
