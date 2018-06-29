/*
 * Created on 2018/06/29
 * Copyright (C) 2018 Koga Laboratory. All rights reserved.
 *
 */

package application;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * タイマーです.
 * @author watanabe
 * @version $Revision$, 2018/06/29
 */
public class Timer {

  /**
   * 時刻を表示するメソッド.
   * @return 戻り値
   */
  public static String timer() {
      Date date = new Date();
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH時mm分ss秒"); //$NON-NLS-1$
      return sdf.format(date);
  }

}
