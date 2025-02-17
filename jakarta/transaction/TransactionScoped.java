/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright (c) 2013 Oracle and/or its affiliates. All rights reserved.
 *
 * The contents of this file are subject to the terms of either the GNU
 * General Public License Version 2 only ("GPL") or the Common Development
 * and Distribution License("CDDL") (collectively, the "License").  You
 * may not use this file except in compliance with the License.  You can
 * obtain a copy of the License at
 * https://glassfish.dev.java.net/public/CDDL+GPL_1_1.html
 * or packager/legal/LICENSE.txt.  See the License for the specific
 * language governing permissions and limitations under the License.
 *
 * When distributing the software, include this License Header Notice in each
 * file and include the License file at packager/legal/LICENSE.txt.
 *
 * GPL Classpath Exception:
 * Oracle designates this particular file as subject to the "Classpath"
 * exception as provided by Oracle in the GPL Version 2 section of the License
 * file that accompanied this code.
 *
 * Modifications:
 * If applicable, add the following below the License Header, with the fields
 * enclosed by brackets [] replaced by your own identifying information:
 * "Portions Copyright [year] [name of copyright owner]"
 *
 * Contributor(s):
 * If you wish your version of this file to be governed by only the CDDL or
 * only the GPL Version 2, indicate your decision by adding "[Contributor]
 * elects to include this software in this distribution under the [CDDL or GPL
 * Version 2] license."  If you don't indicate a single choice of license, a
 * recipient has the option to distribute your version of this file under
 * either the CDDL, the GPL Version 2 or to extend the choice of license to
 * its licensees as provided above.  However, if you add GPL Version 2 code
 * and therefore, elected the GPL Version 2 license, then the option applies
 * only if the new code is made subject to such option by the copyright
 * holder.
 */

package jakarta.transaction;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.enterprise.context.NormalScope;

/**
 * <p>The jakarta.transaction.TransactionScoped annotation provides the ability to
 * specify a standard CDI scope to define bean instances whose lifecycle is
 * scoped to the currently active JTA transaction. This annotation has no effect
 * on classes which have non-contextual references such those defined as managed
 * beans by the Java EE specification. </p>
 *
 * The transaction scope is active when the return from a call to
 *  <code>UserTransaction.getStatus</code> or
 *  <code>TransactionManager.getStatus</code>
 *  is one of the following states:
 *      <li>Status.STATUS_ACTIVE</li>
 *      <li>Status.STATUS_MARKED_ROLLBACK</li>
 *      <li>Status.STATUS_PREPARED</li>
 *      <li>Status.STATUS_UNKNOWN</li>
 *      <li>Status.STATUS_PREPARING</li>
 *      <li>Status.STATUS_COMMITTING</li>
 *      <li>Status.STATUS_ROLLING_BACK</li>
 * <p>It is not intended that the term &quotactive&quot as defined here in relation to the
 *  TransactionScoped annotation should also apply to its use in relation to
 *  transaction context, lifecycle, etc. mentioned elsewhere in this
 *  specification. The object with this annotation will be associated with the
 *  current active JTA transaction when the object is used. This association must
 *  be retained through any transaction suspend or resume calls as well as any
 *  <code>Synchronization.beforeCompletion</code> callbacks. Any
 *  <code>Synchronization.afterCompletion</code> methods will be invoked in an undefined
 *  context. The way in which the JTA transaction is begun and completed
 *  (for example via UserTransaction, Transactional interceptor, etc.) is of no consequence.
 *  The contextual references used across different JTA transactions are distinct.
 *  Refer to the CDI specification for more details on contextual references.
 *  A <code>javax.enterprise.context.ContextNotActiveException</code>
 *  will be thrown if an object with this annotation is used when the
 *  transaction context is not active.</p>
 *
 *  @since JTA1.2
 */
@Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.FIELD})
@NormalScope(passivating=true)
public @interface TransactionScoped {
}
