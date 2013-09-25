package org.robolectric.shadows;

import android.widget.CompoundButton;
import org.robolectric.annotation.Implementation;
import org.robolectric.annotation.Implements;
import org.robolectric.annotation.RealObject;

import static org.robolectric.Robolectric.directlyOn;

/**
 * Shadows the {@code android.widget.CompoundButton} class.
 */
@SuppressWarnings({"UnusedDeclaration"})
@Implements(CompoundButton.class)
public class ShadowCompoundButton extends ShadowTextView {
  @RealObject CompoundButton realCompoundButton;

  private CompoundButton.OnCheckedChangeListener onCheckedChangeListener;

  @Implementation
  public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener listener) {
    onCheckedChangeListener = listener;
    directlyOn(realCompoundButton, CompoundButton.class).setOnCheckedChangeListener(listener);
  }

  public CompoundButton.OnCheckedChangeListener getOnCheckedChangeListener() {
    return onCheckedChangeListener;
  }
}
