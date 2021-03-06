// Copyright 2014 Google Inc. All rights reserved.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//    http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.devtools.build.lib.rules.objc;

import com.google.devtools.build.lib.analysis.TransitiveInfoProvider;
import com.google.devtools.build.lib.collect.nestedset.NestedSet;
import com.google.devtools.build.lib.concurrent.ThreadSafety.Immutable;

/**
 * This provider is exported by java_library rules to supply J2ObjC-translated ObjC sources to
 * objc_binary for compilation and linking.
 */
@Immutable
public final class J2ObjcSrcsProvider implements TransitiveInfoProvider {
  private final NestedSet<J2ObjcSource> srcs;
  private final boolean hasProtos;

  public J2ObjcSrcsProvider(NestedSet<J2ObjcSource> srcs, boolean hasProtos) {
    this.srcs = srcs;
    this.hasProtos = hasProtos;
  }

  public NestedSet<J2ObjcSource> getSrcs() {
    return srcs;
  }

  /**
   * Returns whether the translated source files in the provider has proto files.
   */
  public boolean hasProtos() {
    return hasProtos;
  }
}
