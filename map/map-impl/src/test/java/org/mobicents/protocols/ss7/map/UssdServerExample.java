package org.mobicents.protocols.ss7.map;

import org.mobicents.protocols.ss7.map.api.MAPDialog;
import org.mobicents.protocols.ss7.map.api.MAPDialogListener;
import org.mobicents.protocols.ss7.map.api.MAPException;
import org.mobicents.protocols.ss7.map.api.MAPMessage;
import org.mobicents.protocols.ss7.map.api.MAPParameterFactory;
import org.mobicents.protocols.ss7.map.api.MAPProvider;
import org.mobicents.protocols.ss7.map.api.MAPStack;
import org.mobicents.protocols.ss7.map.api.datacoding.CBSDataCodingScheme;
import org.mobicents.protocols.ss7.map.api.dialog.MAPAbortProviderReason;
import org.mobicents.protocols.ss7.map.api.dialog.MAPAbortSource;
import org.mobicents.protocols.ss7.map.api.dialog.MAPNoticeProblemDiagnostic;
import org.mobicents.protocols.ss7.map.api.dialog.MAPProviderError;
import org.mobicents.protocols.ss7.map.api.dialog.MAPRefuseReason;
import org.mobicents.protocols.ss7.map.api.dialog.MAPUserAbortChoice;
import org.mobicents.protocols.ss7.map.api.errors.MAPErrorMessage;
import org.mobicents.protocols.ss7.map.api.primitives.AddressString;
import org.mobicents.protocols.ss7.map.api.primitives.IMSI;
import org.mobicents.protocols.ss7.map.api.primitives.MAPExtensionContainer;
import org.mobicents.protocols.ss7.map.api.primitives.USSDString;
import org.mobicents.protocols.ss7.map.api.service.supplementary.MAPDialogSupplementary;
import org.mobicents.protocols.ss7.map.api.service.supplementary.MAPServiceSupplementaryListener;
import org.mobicents.protocols.ss7.map.api.service.supplementary.ProcessUnstructuredSSRequest;
import org.mobicents.protocols.ss7.map.api.service.supplementary.ProcessUnstructuredSSResponse;
import org.mobicents.protocols.ss7.map.api.service.supplementary.UnstructuredSSNotifyRequest;
import org.mobicents.protocols.ss7.map.api.service.supplementary.UnstructuredSSNotifyResponse;
import org.mobicents.protocols.ss7.map.api.service.supplementary.UnstructuredSSRequest;
import org.mobicents.protocols.ss7.map.api.service.supplementary.UnstructuredSSResponse;
import org.mobicents.protocols.ss7.map.datacoding.CBSDataCodingSchemeImpl;
import org.mobicents.protocols.ss7.sccp.SccpProvider;
import org.mobicents.protocols.ss7.tcap.asn.ApplicationContextName;
import org.mobicents.protocols.ss7.tcap.asn.comp.Problem;

public class UssdServerExample implements MAPDialogListener, MAPServiceSupplementaryListener {

	private MAPStack mapStack;
	private MAPProvider mapProvider;
	private MAPParameterFactory paramFact;
	private MAPDialogSupplementary currentMapDialog;

	public UssdServerExample(SccpProvider sccpPprovider, int ssn) {
		mapStack = new MAPStackImpl(sccpPprovider, ssn);
		mapProvider = mapStack.getMAPProvider();
		paramFact = mapProvider.getMAPParameterFactory();

		mapProvider.addMAPDialogListener(this);
		mapProvider.getMAPServiceSupplementary().addMAPServiceListener(this);
	}

	public MAPProvider getMAPProvider() {
		return mapProvider;
	}

	public void start() {
		mapStack.start();

		// Make the supplementary service activated
        mapProvider.getMAPServiceSupplementary().acivate();

        currentMapDialog = null;
	}

	public void stop() {
		mapStack.stop();
	}

	public void onProcessUnstructuredSSRequest(ProcessUnstructuredSSRequest ind) {

		USSDString ussdString = ind.getUSSDString();
		try {
			String request = ussdString.getString(null);

			// processing USSD request
			String response = "Your balans is 100$";

			CBSDataCodingScheme ussdDataCodingScheme = new CBSDataCodingSchemeImpl(0x0f);
			USSDString ussdResponse = paramFact.createUSSDString(response, null, null);

			currentMapDialog.addProcessUnstructuredSSResponse(ind.getInvokeId(), ussdDataCodingScheme, ussdResponse);
		} catch (MAPException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public void onDialogDelimiter(MAPDialog mapDialog) {
		// This will initiate the TC-END with ReturnResultLast component
		try {
			currentMapDialog.send();
		} catch (MAPException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public void onErrorComponent(MAPDialog mapDialog, Long invokeId, MAPErrorMessage mapErrorMessage) {
		// TODO Auto-generated method stub
		
	}

	public void onProviderErrorComponent(MAPDialog mapDialog, Long invokeId, MAPProviderError providerError) {
		// TODO Auto-generated method stub
		
	}

	public void onRejectComponent(MAPDialog mapDialog, Long invokeId, Problem problem) {
		// TODO Auto-generated method stub
		
	}

	public void onInvokeTimeout(MAPDialog mapDialog, Long invokeId) {
		// TODO Auto-generated method stub
		
	}

	public void onMAPMessage(MAPMessage mapMessage) {
		// TODO Auto-generated method stub
		
	}

	public void onProcessUnstructuredSSResponse(ProcessUnstructuredSSResponse ind) {
		// TODO Auto-generated method stub
		
	}

	public void onUnstructuredSSRequest(UnstructuredSSRequest unstrReqInd) {
		// TODO Auto-generated method stub
		
	}

	public void onUnstructuredSSResponse(UnstructuredSSResponse unstrResInd) {
		// TODO Auto-generated method stub
		
	}

	public void onUnstructuredSSNotifyRequest(UnstructuredSSNotifyRequest unstrNotifyInd) {
		// TODO Auto-generated method stub
		
	}

	public void onUnstructuredSSNotifyResponse(UnstructuredSSNotifyResponse unstrNotifyInd) {
		// TODO Auto-generated method stub
		
	}

	public void onDialogRequest(MAPDialog mapDialog, AddressString destReference, AddressString origReference, MAPExtensionContainer extensionContainer) {
		// TODO Auto-generated method stub
		
	}

	public void onDialogRequestEricsson(MAPDialog mapDialog, AddressString destReference, AddressString origReference, IMSI eriImsi, AddressString eriVlrNo) {
		// TODO Auto-generated method stub
		
	}

	public void onDialogAccept(MAPDialog mapDialog, MAPExtensionContainer extensionContainer) {
		// TODO Auto-generated method stub
		
	}

	public void onDialogReject(MAPDialog mapDialog, MAPRefuseReason refuseReason, MAPProviderError providerError,
			ApplicationContextName alternativeApplicationContext, MAPExtensionContainer extensionContainer) {
		// TODO Auto-generated method stub
		
	}

	public void onDialogUserAbort(MAPDialog mapDialog, MAPUserAbortChoice userReason, MAPExtensionContainer extensionContainer) {
		// TODO Auto-generated method stub
		
	}

	public void onDialogProviderAbort(MAPDialog mapDialog, MAPAbortProviderReason abortProviderReason, MAPAbortSource abortSource,
			MAPExtensionContainer extensionContainer) {
		// TODO Auto-generated method stub
		
	}

	public void onDialogClose(MAPDialog mapDialog) {
		// TODO Auto-generated method stub
		
	}

	public void onDialogNotice(MAPDialog mapDialog, MAPNoticeProblemDiagnostic noticeProblemDiagnostic) {
		// TODO Auto-generated method stub
		
	}

	public void onDialogRelease(MAPDialog mapDialog) {
		currentMapDialog = null;
	}

	public void onDialogTimeout(MAPDialog mapDialog) {
		// TODO Auto-generated method stub
		
	}
}

